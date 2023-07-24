/**
 *
 */
package com.brc.whitemercurydg.tests;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.brc.whitemercurydg.RunController;
import com.brc.whitemercurydg.RunMode;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author tspaulding
 *
 */
public class DatabaseTest {

	private static final String RUN_MODE_SYS_PROPERTY_VALUE = "database";
	private static final String DB_URL_SYS_PROPERTY = "dbUrl";
	private static final String DB_URL_SYS_PROPERTY_VALUE = "jdbc:mysql://localhost:3306/whitemercurydgtest";
	private static final String BAD_DB_URL_SYS_PROPERTY_VALUE = "jdbc:mysql://dummyhost:3306/whitemercurydgtest";
	private static final String DB_USER_SYS_PROPERTY = "dbUser";
	private static final String DB_USER_SYS_PROPERTY_VALUE = "brc-user";
	private static final String DB_PASSWORD_SYS_PROPERTY = "dbPassword";
	private static final String DB_PASSWORD_SYS_PROPERTY_VALUE = "brc123";
	private static final String CYCLES_SYS_PROPERTY = "cycles";
	private static final String CYCLES_SYS_PROPERTY_VALUE = "100";

    private Connection dbConn = null;
    private Statement dbStmt = null;
    private ResultSet dbResult = null;

    private int initDbCount = 0;

	@BeforeMethod
	public void dbSetup() {
        try {
        	dbConn = DriverManager.getConnection(DB_URL_SYS_PROPERTY_VALUE, DB_USER_SYS_PROPERTY_VALUE, DB_PASSWORD_SYS_PROPERTY_VALUE);
        	dbStmt = dbConn.createStatement();
        	dbResult = dbStmt.executeQuery("SELECT VERSION()");

            if (dbResult.next()) {
                System.out.println(dbResult.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(this.getClass().getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (dbResult != null) {
                	dbResult.close();
                }
                if (dbStmt != null) {
                	dbStmt.close();
                }
                if (dbConn != null) {
                	dbConn.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(this.getClass().getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

	}

	@Test(enabled = false, groups = { "full" })
	public void databaseSmokeTest() {
		String output = null;
		RunController runner = new RunController();
		String[] args = {};
		RunMode runMode = RunMode.fromString(RUN_MODE_SYS_PROPERTY_VALUE);
		URL log4jConfig = this.getClass().getClassLoader().getResource("generator.xml");
		int count = 0;
		System.setProperty(DB_URL_SYS_PROPERTY, DB_URL_SYS_PROPERTY_VALUE);
		System.setProperty(DB_USER_SYS_PROPERTY, DB_USER_SYS_PROPERTY_VALUE);
		System.setProperty(DB_PASSWORD_SYS_PROPERTY, DB_PASSWORD_SYS_PROPERTY_VALUE);
		System.setProperty(CYCLES_SYS_PROPERTY, CYCLES_SYS_PROPERTY_VALUE);

		try {
			output = runner.runByMode(args, runMode, log4jConfig);
			System.out.println(output);
			count = recordCount();
			assertEquals(count, Integer.parseInt(CYCLES_SYS_PROPERTY_VALUE));
		} catch (Exception ex) {
			System.err.println(ex);
			ex.printStackTrace();
			fail("Unexpected exception during test.", ex);
		}

		assertNotNull(output);
	}

	private int recordCount() {
		//int count = 0;


		return Integer.parseInt(CYCLES_SYS_PROPERTY_VALUE);
	}

	@Test(groups = { "full" })
	public void badDbUrlTest() {
		String output = null;
		RunController runner = new RunController();
		String[] args = {};
		RunMode runMode = RunMode.fromString(RUN_MODE_SYS_PROPERTY_VALUE);
		URL log4jConfig = this.getClass().getClassLoader().getResource("generator.xml");
		System.setProperty(DB_URL_SYS_PROPERTY, BAD_DB_URL_SYS_PROPERTY_VALUE);
		System.setProperty(DB_USER_SYS_PROPERTY, DB_USER_SYS_PROPERTY_VALUE);
		System.setProperty(DB_PASSWORD_SYS_PROPERTY, DB_PASSWORD_SYS_PROPERTY_VALUE);
		System.setProperty(CYCLES_SYS_PROPERTY, CYCLES_SYS_PROPERTY_VALUE);

		try {
			output = runner.runByMode(args, runMode, log4jConfig);
			assertNotNull(output);
		} catch (Exception ex) {
			if (!(ex instanceof CommunicationsException)) {
				System.err.println(ex);
				ex.printStackTrace();
				fail("Unexpected exception during test.", ex);
			}
		}
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

	public Statement getDbStmt() {
		return dbStmt;
	}

	public void setDbStmt(Statement dbStmt) {
		this.dbStmt = dbStmt;
	}

	public ResultSet getDbResult() {
		return dbResult;
	}

	public void setDbResult(ResultSet dbResult) {
		this.dbResult = dbResult;
	}

	public int getInitDbCount() {
		return initDbCount;
	}

	public void setInitDbCount(int initDbCount) {
		this.initDbCount = initDbCount;
	}
}
