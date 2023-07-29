/**
 *
 */
package com.brc.whitemercurydg;

import java.net.URL;


/**
 * @author tim
 *
 */
public class WhiteMercuryDGMain {

	public static final int EXIT_FAILURE = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String output = null;
		RunController runner = new RunController();
		RunMode sitRunMode = RunMode.fromString(System.getProperty("runMode"));
		URL log4jConfig = WhiteMercuryDGMain.class.getResource("/log4j2.xml");

		try {
			output = runner.runByMode(args, sitRunMode, log4jConfig);

			if (output != null) {
				System.out.println(output);
			}
		} catch (Exception ex) {
			System.err.println(ex.toString());
			System.exit(EXIT_FAILURE);
		}
	}

}
