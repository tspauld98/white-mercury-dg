/**
 *
 */
package com.brc.whitemercurydg.generator.engine.db;

import generator.db.DBFieldGenerator;
import generator.db.DBGeneratorDefinition;
import generator.db.DBTableGenerator;
import generator.engine.ProgressUpdateObserver;
import generator.extenders.IRandomiserFunctionality;
import generator.extenders.RandomiserInstance;
import generator.misc.ApplicationContext;
import generator.misc.DBDriverInfo;
import generator.misc.RandomiserType;
import generator.misc.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

/**
 * @author tspaulding
 *
 */
public class Generator {

    private Vector<RandomiserType> vRandomiserTypes;
    private Vector<RandomiserInstance> vRandomiserInstances;
    private Vector<DBDriverInfo> vDBDriverInfo;
    private DBGeneratorDefinition dbGenConfig;
    private Logger logger = LogManager.getLogger(Generator.class);
    private ProgressUpdateObserver observer;

    public Generator() {
        //load the randomiser-type definitions from file
        vRandomiserTypes = ApplicationContext.getInstance().getRandomiserTypes();

        //load the randomiser-instance definitions from the file
        vRandomiserInstances = ApplicationContext.getInstance().getRandomiserInstances();

        //load the db drivers info
        vDBDriverInfo = ApplicationContext.getInstance().getDriverInfo();

        logger = LogManager.getLogger(Generator.class);
    }

	/**
	 * @return the vRandomiserTypes
	 */
	public Vector<RandomiserType> getvRandomiserTypes() {
		return vRandomiserTypes;
	}

	/**
	 * @param vRandomiserTypes the vRandomiserTypes to set
	 */
	public void setvRandomiserTypes(Vector<RandomiserType> vRandomiserTypes) {
		this.vRandomiserTypes = vRandomiserTypes;
	}

	/**
	 * @return the vRandomiserInstances
	 */
	public Vector<RandomiserInstance> getvRandomiserInstances() {
		return vRandomiserInstances;
	}

	/**
	 * @param vRandomiserInstances the vRandomiserInstances to set
	 */
	public void setvRandomiserInstances(Vector<RandomiserInstance> vRandomiserInstances) {
		this.vRandomiserInstances = vRandomiserInstances;
	}

	/**
	 * @return the vDBDriverInfo
	 */
	public Vector<DBDriverInfo> getvDBDriverInfo() {
		return vDBDriverInfo;
	}

	/**
	 * @param vDBDriverInfo the vDBDriverInfo to set
	 */
	public void setvDBDriverInfo(Vector<DBDriverInfo> vDBDriverInfo) {
		this.vDBDriverInfo = vDBDriverInfo;
	}

	/**
	 * @return the dbGenConfig
	 */
	public DBGeneratorDefinition getDbGenConfig() {
		return dbGenConfig;
	}

	/**
	 * @param dbGenConfig the dbGenConfig to set
	 */
	public void setDbGenConfig(DBGeneratorDefinition dbGenConfig) {
		this.dbGenConfig = dbGenConfig;
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * @return the observer
	 */
	public ProgressUpdateObserver getObserver() {
		return observer;
	}

	/**
	 * @param observer the observer to set
	 */
	public void setObserver(ProgressUpdateObserver observer) {
		this.observer = observer;
	}

	public void generate() throws ClassNotFoundException, SQLException, Exception {
    	StopWatch stopWatch = new LoggingStopWatch("Generator.generate()");

        int numOfRecs = dbGenConfig.getCycles();
        List<DBTableGenerator> alDBGenerators = dbGenConfig.getDBTableGenerators();
        int i = 0;
        int j = 0;
        Connection connection = null;
        Map<String, IRandomiserFunctionality> hmIGenerators = new HashMap<String, IRandomiserFunctionality>();
        Map<String, String> hmDelimeters = new HashMap<String, String>();
        PreparedStatement statement = null;
        String sQuery = null;

		try {
			Class.forName(dbGenConfig.getDbDriver());
			connection = (Connection) DriverManager.getConnection(dbGenConfig.getDbURL(), dbGenConfig.getUser(), dbGenConfig.getPassword());
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw e;
		}

        initializeGenerators(alDBGenerators, hmIGenerators, hmDelimeters);

        StopWatch sqlGenStopWatch = new LoggingStopWatch("Generator.generate().sqlStatementGenerationCodeBlock");
        for (DBTableGenerator dbT : alDBGenerators) {
        	try {
        		sQuery = generateQueryTemplate(dbT);
            	statement = (PreparedStatement) connection.prepareStatement(sQuery);
                logger.debug(sQuery);
        	} catch (SQLException e) {
        		e.printStackTrace();
        		throw e;
        	}

            List<DBFieldGenerator> aDBFieldsGenerators = dbT.getDBFieldGenerators();

	        while (i < numOfRecs) {
	            i++;

	            for (DBFieldGenerator dbFieldGen : aDBFieldsGenerators) {
	            	j++;

	                Object objGeneratedValue = null;
	                IRandomiserFunctionality iGenerator;
	                String id = dbT.getName() + "." + dbFieldGen.getField();

	                iGenerator = (IRandomiserFunctionality) hmIGenerators.get(id);
	                if (iGenerator != null) {
	                    objGeneratedValue = iGenerator.generate();
	                } else {
	                    logger.error("POSSIBLE ERROR: No foreign key value found for null generator: " + id);
	                }

	                try {
						statement.setString(j, (String) objGeneratedValue);
					} catch (SQLException e) {
						e.printStackTrace();
						throw e;
					}
	            }

	            try {
					statement.addBatch();
					j = 0;
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
	        }
	        sqlGenStopWatch.stop();

	        StopWatch sqlExeStopWatch = new LoggingStopWatch("Generator.generate().sqlStatementExecutionCodeBlock");
	        try {
				int[] updateCounts = statement.executeBatch();
				if (numOfRecs == updateCounts.length) {
					connection.commit();
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
	        sqlExeStopWatch.stop();
        }

        stopWatch.stop();
	}

    private void initializeGenerators(List<DBTableGenerator> alDBGenerators, Map<String, IRandomiserFunctionality> mapGenerators, Map<String, String> mapDelimiters) {
    	StopWatch stopWatch = new LoggingStopWatch("Generator.initializeGenerators()");

        IRandomiserFunctionality iGenerator;
        Utils utils = new Utils();
        DBDriverInfo dbDriverInfo = utils.findDBDriver(dbGenConfig.getDbDriver(), vDBDriverInfo);

        for (DBTableGenerator dbTableGenerator : alDBGenerators) {
            System.out.println("xxxxxxxxxxxxxxxxx" + dbTableGenerator.getName());
            List<DBFieldGenerator> aDBFieldsGenerators = dbTableGenerator.getDBFieldGenerators();
            for (DBFieldGenerator dbFieldGen : aDBFieldsGenerators) {

                //A field may have no generators assigned to it, that's normal, we skip that
                if (dbFieldGen.getGenerator() == null || dbFieldGen.getGenerator().length()==0) {
                    logger.debug("POSSIBLE ERROR: No generator for " + dbTableGenerator.getName() + "." + dbFieldGen.getField());
                    continue;
                }

                //if we are here, we have a field with a generator assigned to it

                //the id of the table field we want to generate data for
                String id = dbTableGenerator.getName() + "." + dbFieldGen.getField();

                //create the randomiser instance out of the name
                RandomiserInstance ri = getRandomiserInstance(dbFieldGen.getGenerator());

                //get the randomiser type out of the RI
                RandomiserType rt = getRandomiserType(ri.getRandomiserType());

                //load and store the generator, set its RI, now it is ready to use
                iGenerator = (IRandomiserFunctionality) utils.createObject(rt.getGenerator());
                iGenerator.setRandomiserInstance(ri);

                // this particular field is associated with the generator created above
                mapGenerators.put(id, iGenerator);

                //once a value is generated for this field, we need to wrap it up in the appropriate delimeters
                String delimiter = "";
                switch (rt.getJtype()) {
                case RandomiserType.TYPE_STRING:
                	delimiter = dbDriverInfo.getCharDelimiter();
                	break;
                case RandomiserType.TYPE_DATE:
                	delimiter = dbDriverInfo.getDateDelimiter();
                	break;
                case RandomiserType.TYPE_TIME:
                	delimiter = dbDriverInfo.getTimeDelimiter();
                	break;
                case RandomiserType.TYPE_TIMESTAMP:
                	delimiter = dbDriverInfo.getTimestampDelimiter();
                	break;
                }
                if (delimiter != null) {
                    mapDelimiters.put(id, new String(delimiter));
                }
            }
        }

        stopWatch.stop();
	}

    /**
     * Returns a RandomiserInstance object, given a string.
     * Preconditions: vRandomiserInstances must NOT be null :)
     */
    private RandomiserInstance getRandomiserInstance(String riName)
    {
        RandomiserInstance randomizerInstance = null;

        logger.debug("Retrieving randomiserInstance object for:" + riName);

        for (RandomiserInstance ri : vRandomiserInstances)
        {
            if (ri.getName().equalsIgnoreCase(riName))
            {
                randomizerInstance = ri;
                break;
            }
        }

        logger.debug("Retrieving the randomiserInstance for:" + riName + ". Found:" + randomizerInstance != null ? true : false);
        return randomizerInstance;
    }

    /**
     * Returns the name of a RandomiserType class,
     * given its name in the application.
     * Preconditions: vRandomiserTypes must NOT be null :)
     */
    private RandomiserType getRandomiserType(String randomiserType)
    {
        RandomiserType randomizerType = null;

        logger.debug("Retrieving randomiserType object for:" + randomiserType);
        for (RandomiserType rt : vRandomiserTypes)
        {
            if (rt.getName().equalsIgnoreCase(randomiserType))
            {
                randomizerType = rt;
                break;
            }
        }

        logger.debug("Retrieving the randomiserType for:" + randomiserType + ". Found:" + randomizerType != null ? randomizerType.getName() : "false");
        return randomizerType;
    }

    /**
     * Generates a query template for table dbTableGenerator
     *
     * @param dbTableGenerator
     * @return String - the generated query template
     */
    private String generateQueryTemplate(DBTableGenerator dbTableGenerator)
    {
        List<DBFieldGenerator> aDBFieldsGenerators = dbTableGenerator.getDBFieldGenerators();

        StringBuffer sbQuery = new StringBuffer();
        StringBuffer sbFields = new StringBuffer();
        StringBuffer sbValues = new StringBuffer();
        sbFields.append("(");
        sbValues.append("(");

        sbQuery.append("INSERT INTO ");
        sbQuery.append(dbTableGenerator.getName());

        for (DBFieldGenerator dbFieldGen : aDBFieldsGenerators) {
        	if (dbFieldGen.getGenerator() != null && dbFieldGen.getGenerator().length() > 0) {
        		sbValues.append("?");
        		sbValues.append(",");

                sbFields.append(dbFieldGen.getField());
                sbFields.append(",");
            }
        }

        sbFields.deleteCharAt(sbFields.length() - 1);
        sbFields.append(")");

        sbValues.deleteCharAt(sbValues.length() - 1);
        sbValues.append(")");

        sbQuery.append(" ");
        sbQuery.append(sbFields);
        sbQuery.append(" VALUES ");
        sbQuery.append(sbValues);

        return sbQuery.toString();
    }

}
