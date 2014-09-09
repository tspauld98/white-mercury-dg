/**
 *
 */
package com.brc.whitemercurydg.tests;

import org.testng.annotations.Test;

import com.brc.whitemercurydg.WhiteMercuryDGMain;

/**
 * @author tspaulding
 *
 */
public class MainTest {


	@Test(groups = { "full", "smoke" })
	public void mainSmokeTest() {
		String[] args = {};
		WhiteMercuryDGMain.main(args);
	}

}
