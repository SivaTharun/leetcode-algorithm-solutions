package com.strings.practice;

/**
 * 151. Reverse Words in a String
 *  Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 
 * @author SivaTharun
 *
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {

		String input = " the sky is blue ";
		System.out.println(getReverseWordsInString(input));
	}
	
	/**
	 * Space Complexity-O(n)
	 * Time Complexity-O(n)
	 * Reverse the string and create a new string by reversing and appending a new word to the string.
	 * @param input
	 * @return
	 */
	static String getReverseWordsInString(String input) {
		String trimmedReversedString = trimLeadingANdTrailingSpaces(input);
		StringBuilder sdb= new StringBuilder();
		int currentCharacterIndex = 0;
		int len=trimmedReversedString.length();
		for(int j=0;j<len;j++) {
			if(trimmedReversedString.charAt(j)==' ') {
				//logic to skip extra spaces b/w the words
				if(j<=len-1&&trimmedReversedString.charAt(j+1)!=' ') {
				StringBuilder sb1=new StringBuilder();
				sb1.append(trimmedReversedString.substring(currentCharacterIndex, j));
				sdb.append(sb1.reverse().toString());
				sdb.append(' ');
				currentCharacterIndex=j+1;
				} else 
					continue;
			}
			
		}
		StringBuilder temp = new StringBuilder();
		sdb.append(temp.append(trimmedReversedString.substring(currentCharacterIndex, len)).reverse());
		return sdb.toString();
	}
	
	static String trimLeadingANdTrailingSpaces(String input) {
		int len = input.length();
		
		//trim leading zeroes
		boolean isLeadingSpaceCharacters = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++) {
			if(input.charAt(i)==' ') {
			if(!isLeadingSpaceCharacters) 
				//leading spaces case
				continue;
			else
			{
				sb.append(input.charAt(i));
			}
			}
			else {
				isLeadingSpaceCharacters=true;
				sb.append(input.charAt(i));
			}
		}
		//trim trailing spaces
		String temp = sb.toString();
		int len1= temp.length();
		StringBuilder sb1 = new StringBuilder();
		boolean isTrailingSpace = false;
		for(int j=len1-1;j>=0;j--) {
			if(temp.charAt(j)==' ') {
				if(!isTrailingSpace) {
					continue;
				}else {
					sb1.insert(0,temp.charAt(j));
				}
			}else {
				isTrailingSpace=true;
				sb1.insert(0,temp.charAt(j));
			}
		}
		
		return sb1.reverse().toString();
	}

}
