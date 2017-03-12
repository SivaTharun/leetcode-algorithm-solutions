package com.strings.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String input="abadef";
		System.out.println(getLongestSubStringWithoutRepeatingLengthSlidingWindow(input));
	}
	
	/*static String getLongestSubStringwithoutrepeatingCharacters(String input) {
		StringBuilder sb = new StringBuilder();
		int latestIndex = 0;
		Set<Character> charSet = new HashSet<>();
		for(int i=0;i<input.length()-1;i++) {
			if(input.charAt(i)!=input.charAt(i+1)) {
				{
					if(latestIndex==0&&i==0) {
						sb.append(input.charAt(i));
						charSet.add(input.charAt(i));
					}else {
					if(i==latestIndex+1)
					{
						if(!charSet.contains(input.charAt(i))) {
						sb.append(input.charAt(i));
						latestIndex=i;
						}
					}
					}
				}
			}
			else 
				continue;
		}
		return sb.toString();
		
	}*/
	
	/**
	 *
	 *Naive Approach-
	 *Compare the size of all the non repeating character sub string s of the current string.there will be n(n+1)/2 sub strings 
	 *present in the string but we have to check whether there are duplicate characters.
	 * Time Complexity-O(n^3)
	 * 
	 */
	static int getLongestSubStringWithoutRepeatingLength(String input) {
		int len=input.length();
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<len;i++) {
			//checking the length of all possible valid sub strings in this case
			for(int j=i+1;j<len;j++) {
				if(isContainsUniqueCharacters(i,j,input))
					ans=Math.max(ans, j-i);
			}
		}
		return ans;
	}
	
	static boolean isContainsUniqueCharacters(int start,int end,String input) {
		HashSet<Character> characterHashSet = new HashSet<>();
		for(int i=start;i<end;i++) {
			if(!characterHashSet.contains(input.charAt(i))) {
				characterHashSet.add(input.charAt(i));
			}
			else
				return false;
			
		}
		return true;
	}
	
	/**
	 * A sliding window is an abstract concept commonly used in array/string problems. 
	 * A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction. For example, if we slide [i,j) to the right by 1 element, then it becomes [i+1,j+1) (left-closed, right-open).
	 * 
	 * Time Complexity-O(n)
	 * window limit-->[i,j]
	 */
	static int getLongestSubStringWithoutRepeatingLengthSlidingWindow(String input) {
		int len = input.length();
		//intialize both the start index of window to staring of the string index.
		int i=0;int j=0;
		int ans = Integer.MIN_VALUE;
		Set<Character> charSet = new HashSet<>();
		while(i<len&&j<len) {
			if(!charSet.contains(input.charAt(j)))
			{
				charSet.add(input.charAt(j++));
				ans=Math.max(ans, j-i);
				//incrementing the j value to check for the next character (increase window size)
			}
			else {
				charSet.remove(input.charAt(i));
				//increamenting the i value to decresase the window size 
				i++;
			}
		}
	
		return ans;
	}
	
}
