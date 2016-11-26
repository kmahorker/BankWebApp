package org.innominds.intern.BankWebApp;

/**
 * A class meant to be used for universal methods on the need basis that are used in many different classes
 * @author Kaushik
 *
 */
public class Universal {

	/**
	 * Returns whether or not a String can be converted into an Integer or not
	 * @param input
	 * @return
	 */
	public static boolean isParsable(String input) {
		boolean parsable = true;
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			parsable = false;
		}
		return parsable;
	}

}
