package in.co.sunrays.proj0.util;
/**
 * Use for check Custom validation.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 * 
 */
public class DataValidator {

	/**
	 * Checks if value is Null
	 * 
	 * @param val:
	 * 				String value
	 * @return boolean
	 */
	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if value is NOT Null
	 * 
	 * @param val:
	 * 				String Value
	 * @return boolean
	 */
	public static boolean isNotNull(String val) {
		return !isNull(val);
	}
	
	/**
	 * Checks if value is an Integer
	 * 
	 * @param val:
	 * 				String Value
	 * @return boolean
	 */

	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}
}
