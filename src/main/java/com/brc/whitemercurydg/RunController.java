/**
 *
 */
package com.brc.whitemercurydg;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import org.apache.log4j.xml.DOMConfigurator;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import com.brc.whitemercurydg.generator.engine.json.Generator;
import com.brc.whitemercurydg.generator.misc.JSONDataFileDefinition;
import com.brc.whitemercurydg.generator.misc.JSONDataFileOutputSAXHandler;

import generator.db.DBGeneratorDefinition;
import generator.db.DBTableGenerator;
import generator.gui.MainForm;
import generator.misc.ApplicationContext;
import generator.misc.RandomDefinitionsBuilder;

/**
 * @author tspaulding
 *
 */
public class RunController {

	private MainForm legacyUI;

	public String runByMode(String[] args, RunMode currRunMode, URL log4jConfig) throws Exception {
		String output = "";

		for (String arg : args) {
			output = output + outputBanner("Argument List");
			output = output + "Argument: " + arg + "\n";
		}

	    DOMConfigurator.configure(log4jConfig);

		switch (currRunMode) {
			case DATABASE:
				output = generateDatabase(output);
				break;
			case JSON:
				output = generateJSON(output);
				break;
			case LEGACY:
				runLegacySwingUI(args);
				break;
			case TEST:
				output = generateTestFile(output);
				break;
			default:
				output = generateUsage(output);
		}

		return output;
	}

	public String generateDatabase(String output) throws ClassNotFoundException, SQLException, Exception {
		StopWatch stopWatch = new LoggingStopWatch("whitemercurydgMain.generateDatabase()");

		com.brc.whitemercurydg.generator.engine.db.Generator generator = new com.brc.whitemercurydg.generator.engine.db.Generator();
		DBGeneratorDefinition currDefinition = new DBGeneratorDefinition();

		output = output + outputBanner("Generating database data...");

		populateDefinitionWithDefaults(currDefinition);

		output = output + currDefinition.outputDefinition();

        generator.setDbGenConfig(currDefinition);
        generator.generate();

        stopWatch.stop();

        return output;
	}

	private void populateDefinitionWithDefaults(DBGeneratorDefinition currDef) {
		DBTableGenerator currTblGen = new DBTableGenerator();

		currDef.setScenario("Default MySQL T_MASTER Load");
		currDef.setDescription("Loads the default number of rows into a local instance of mysql with the default structure for T_MASTER.");
		currDef.setDbDriver("com.mysql.jdbc.Driver");
		currDef.setDbURL(System.getProperty("dbUrl", "jdbc:mysql://localhost:3306/whitemercurydgtest"));
		currDef.setUser(System.getProperty("dbUser", "root"));
		currDef.setPassword(System.getProperty("dbPassword"));
		currDef.setCycles(Integer.parseInt(System.getProperty("cycles", "10")));

		currDef.setDBTableGenerators(new ArrayList<DBTableGenerator>());
		currTblGen.populateTableGeneratorWithDefaults();
		currDef.getDBTableGenerators().add(currTblGen);
	}

	private String generateJSON(String output) throws Exception {
		Generator generator = new Generator();
		WhiteMercuryProgressObserver observer = new WhiteMercuryProgressObserver();

		output = output + outputBanner("Generating T_MASTER json file...");

        generator.registerObserver(observer);
        generator.setEngineData(ApplicationContext.getInstance().getRandomiserTypes(), ApplicationContext.getInstance().getRandomiserInstances(), loadJSONDataFileDefinitions());
        if (generator.setFileDefinitionOutput("generate_tmaster_json_" + Integer.parseInt(System.getProperty("cycles", "100")))) {
            generator.generate();
        } else {
        	throw new Exception("JSON file definition not found, will do nothing.");
        }

		return output;
	}

    @SuppressWarnings("unchecked")
	private Vector<JSONDataFileDefinition> loadJSONDataFileDefinitions() {
        Vector<JSONDataFileDefinition> vData;
        RandomDefinitionsBuilder builder = new RandomDefinitionsBuilder();

        builder.setFilename("JSONFileDefinitions.xml");
        builder.setSAXHandler(new JSONDataFileOutputSAXHandler() );
        vData = builder.getElements();

        return vData;
    }

	public void runLegacySwingUI(String[] args) {
		legacyUI = new MainForm();
		legacyUI.setVisible(true);
	}

	public void disposeLegacyUI() {
		legacyUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		legacyUI.dispose();
	}

	public String generateTestFile(String output) throws Exception {
		generator.engine.file.Generator generator = new generator.engine.file.Generator();
		WhiteMercuryProgressObserver observer = new WhiteMercuryProgressObserver();

		output = output + outputBanner("Generating test file...");

        generator.registerObserver(observer);
        generator.setEngineData(ApplicationContext.getInstance().getRandomiserTypes(), ApplicationContext.getInstance().getRandomiserInstances(), ApplicationContext.getInstance().getDFD());
        if (generator.setFileDefinitionOutput("generate_test")) {
            generator.generate();
        } else {
        	throw new Exception("Test file definition not found, will do nothing.");
        }

        return output;
	}

	private String outputBanner(String msg) {
		String output = "";

        output = "\n\n\n\n";
        output = output + "################################################################################\n";
        output = output + "##  " + msg + "\n";
        output = output + "################################################################################\n";
        output = output + "\n\n\n\n";

        return output;
	}

	public String generateUsage(String output) {
		output = output + "Usage:\n";
		output = output + "\tjava [options] -jar [path to jar]white-mercury-dg-[version qualifer]-shaded.jar\n\n";
		output = output + "Description:\n";
		output = output + "\tThe White Mercury Data Generation tool is an executable shaded jar file.\n";
		output = output + "\tA \'shaded\' jar is a jar with all of it's run-time dependencies packed\n";
		output = output + "\tinside it.  The runMode option sets the primary operating mode for this\n";
		output = output + "\tutility.  All options are passed as Java system options.\n\n";
		output = output + "Options:\n";
		output = output + "\t-DrunMode=[legacy | test | database]\n";
		output = output + "\t\tlegacy - run the utility with the legacy Swing UI from dgMaster.\n";
		output = output + "\t\ttest - run the utility with default parameters to generate a test file.\n";
		output = output + "\t\tdatabase - run the utility to generate data in a database.\n";
		output = output + "\t-DdbUrl=[URL of target database]\n";
		output = output + "\t\tDefaults to localhost.  Only applicable when runMode is set to 'database'\n";
		output = output + "\t-DdbUser=[user name for target database]\n";
		output = output + "\t\tDefaults to root.  Only applicable when runMode is set to 'database'\n";
		output = output + "\t-DdbPassword=[password for target database]\n";
		output = output + "\t\tOnly applicable when runMode is set to 'database'\n";
		output = output + "\t-Dcycles=[number of rows to generate in target database]\n";
		output = output + "\t\tDefaults to 10 rows.  Only applicable when runMode is set to 'database'\n";

		return output;
	}

}
