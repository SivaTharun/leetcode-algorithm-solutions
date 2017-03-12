package com.strings.practice;

/**
 *  28.Implement strStr().
	Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	Needle in Hay stack problem. 
 * @author SivaTharun
 *
 */
public class ImplementstrStr {

	public static void main(String[] args) {
		
		String hayStack = "abcde";
		String needle = "cd";
		System.out.println(implementstrStr(hayStack, needle));
	}
	
	//naive solution-iterating through each of the characters in the  strings and check if the characters are matching or not.
	//if all characters are matching then return the value of starting index.
	//Time Complexity-O(n*m) n-length of needle,m-length of haystack
	//space complexity-O(1)
	static int implementstrStr(String hayStack,String needle) {
		if(hayStack==null || needle==null) return -1;
		//empty string is the substring of every string
		if(needle.isEmpty())return 0;
		if(hayStack.isEmpty()) return -1;
		
		int needleLength=needle.length();
		int hayStackLength = hayStack.length();
		
		for(int i=0;i<hayStackLength;i++) {
			int m = i;
			//check for needle length overflow
			if(needleLength+i>hayStackLength)
				return -1;
			for(int j=0;j<needleLength;j++) {
				if(hayStack.charAt(m)==needle.charAt(j)) {
					//increment to next character and check if j is equal to needle length. 
					m++;
					if(j==needleLength-1)return i;
				}
				else 
					//continue the outer loop with the next index of i.
					break;
				
				//return the starting index of matching of haystack sequwnce from needle
				
			}
		}
		
		//if no needle is not found in haystack.
		return -1;
		
	}
}
