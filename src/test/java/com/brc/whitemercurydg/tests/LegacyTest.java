/**
 * 
 */
package com.brc.whitemercurydg.tests;

import java.net.URL;

import org.testng.annotations.Test;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertEquals;

import com.brc.whitemercurydg.RunController;
import com.brc.whitemercurydg.RunMode;

/**
 * @author tspaulding
 *
 */
public class LegacyTest {

	private static final String RUN_MODE_SYS_PROPERTY_VALUE = "legacy";
		 
	@Test(enabled = true, groups = { "full", "smoke" })
	public void legacySmokeTest() {
		String output = null;
		RunController runner = new RunController();
		String[] args = {};
		RunMode runMode = RunMode.fromString(RUN_MODE_SYS_PROPERTY_VALUE);
		URL log4jConfig = this.getClass().getClassLoader().getResource("generator.xml");
		
		if (!Boolean.parseBoolean(System.getProperty("java.awt.headless"))) {
			try {
				output = runner.runByMode(args, runMode, log4jConfig);
		
				Thread.sleep(5000);
			} catch (Exception ex) {
				fail("Unexpected exception during test.", ex);
			}
			
			runner.disposeLegacyUI();
		} else {
			output = "";
		}
		
		assertEquals(output, "");
	}

}
