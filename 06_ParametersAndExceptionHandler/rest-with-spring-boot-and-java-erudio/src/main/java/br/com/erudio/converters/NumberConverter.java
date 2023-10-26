package br.com.erudio.converters;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private static boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			throw new NullPointerException("The String can not null");
		}
		String number = strNumber.replaceAll(",", ".");
		if(number.matches("[-+]?[0-9]*\\.?[0-9]+")) {
			return true;
		} else {
			throw new UnsupportedMathOperationException("Please set a numeric value"); 
		}
	}
}
