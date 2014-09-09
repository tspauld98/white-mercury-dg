/**
 * 
 */
package com.brc.whitemercurydg;

/**
 * @author tspaulding
 *
 */
public enum RunMode {
	UNSET("unset"),
	LEGACY("legacy"),
	TEST("test"),
	JSON("json"),
	DATABASE("database");

	private String text;
	
	RunMode(String text) {
		if (text == null) {
			this.text = "unset";
		} else {
			this.text = text;
		}
	}
	
	public String getText() {
		return this.text;
	}
	
	public static RunMode fromString(String text) {
		RunMode currMode = UNSET;
		
		if (text != null) {
			for (RunMode rm : RunMode.values()) {
				if (text.equalsIgnoreCase(rm.text)) {
					currMode = rm;
					break;
				}
			}
		}

		return currMode;

	}
}
