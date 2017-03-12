package com.strings.practice;

/**
 * 125. Valid Palindrome 
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	For example,"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome. 
 * @author SivaTharun
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		String input="A man, a plan, a canal: Panama";
		System.out.println(isValidPalindrome(input));
	}
	
	//two pointer technique
	//time complexity-O(n)
	//space complexity-O(1)
	static boolean isValidPalindrome(String input) {
		if(input.isEmpty())return true;
		char[] charArray = input.toCharArray();
		int i=0;
		int j= charArray.length-1;
		while(i<j) {
			if(!Character.isLetterOrDigit(charArray[i])) {
				i++;
				continue;
			}
			if(!Character.isLetterOrDigit(charArray[j])) {
				j--;
				continue;
			}
			if(Character.compare(Character.toLowerCase(charArray[i]), Character.toLowerCase(charArray[j]))!=0)
				return false;
			i++;
			j--;
		}
		return true;
	}

}
