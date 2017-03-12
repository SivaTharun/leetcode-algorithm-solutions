package com.strings.practice;

/**
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 * @author SivaTharun
 *
 */
public class IntegertoRoman {

	public static void main(String[] args) {
		int input=2014;
		System.out.println(integerToRoman(input));
	}
	
	static String integerToRoman(int input) {
		
		StringBuilder sb = new StringBuilder();
		String[] romanArray =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] integerArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		for(int i=0;i<integerArray.length;i++) {
			while(input>=integerArray[i]) {
				input=input-integerArray[i];
				sb.append(romanArray[i]);
			}
		}
		
		return sb.toString();
}
}
