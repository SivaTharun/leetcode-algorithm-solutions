package com.strings.practice;

/**
 * 
 * 
 * @author SivaTharun
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		
		String s= "10";
		System.out.println(decodeWays(s));
		
	}
  
	
	/*
	  The number of ways decoding "12" is 2.
	 
	 * solution by zingshow on June 27, 2013
	 * two algorithms to solve this problem
	 * 1. graph + depth-first search (DFS) + recursion
	 * 2. dynamic programming (DP) (current code). it is very similar to "Climbing 
	 * Stairs" question. Find the solution to sub-problem first and grow sub-problem.
	 * 
	 * algorithm 2:
	 * 1) find the number of ways to decode the first char: 1 if the first char 
	 * (char 1) is between "1" and "9", 0 if else (and return 0). 
	 * we can assume a virtual char (char 0)
	 * is before the first char and the number of ways to decode it is 1.
	 * 2) decode the string until second char (char 2) 
	 * and the rest with four situations: 
	 * 
	 * a) if char n is ("1" to "9") and char n-1 + char n is ("10" to "26"), 
	 * the number of ways to decode 
	 * the string until char n is the sum of the number of ways of 
	 * decoding the string until char n-1 and decoding the string until char n-2: 
	 * for string until char 2, it is number of ways for char 0 
	 * plus number of ways for char 1;
	 * 
	 * b) if char n is ("1" to "9") but char n-1 + char n is not ("10" to "26"), 
	 * the number of ways to decode the string until char n
	 * is equal to the number of ways to decode the string until char n-1:
	 * for string until char 2, it is equal to the number of ways for char 1;
	 * 
	 * c) if char n is not ("1" to "9") but char n-1 + char n is ("10" to "26"), 
	 * the number of ways to decode the string until char n
	 * is equal to the number of ways to decode the string until char n-2:
	 * for string until char 2, it is equal to number of ways for char 0;
	 * 
	 * d) if neither char n is ("1" to "9") nor char n-1 + char n is ("10" to "26"), 
	 * the number of ways to decode the string until char n is zero and zero can 
	 * be returned immediately
	 * 
	 * comments: DP has less time and space complexity O(1).
	 * 
	 */
	static int getDecodeWays(String s) {
		
		char [] charArray=s.toCharArray();
		int n = charArray.length;
		int[] numEncode = new int[n+1];
		//base condition
		numEncode[0]=1;
		if(charArray[1]>='1' &&charArray[1]<='9')
			//number of ways encoding for a single digit
			numEncode[1]=1;
		else
			return 0;
		//check the substrings of lenth 2
		for(int i=1;i<n;i++) {
			if(charArray[i]>='1'&&charArray[i]<='9') {
				if(s.substring(i-1,i+1).compareTo("10")>=0&&s.substring(i-1,i+1).compareTo("26")<=0) {
					//the no of ways of expressing sunstring (i-1,i+1)is sum of substring [i]&&substring[i+1]
					
					numEncode[i+1]=numEncode[i]+numEncode[i-1];
				}else 
				{
					numEncode[i+1]=numEncode[i];
				}
			}else 
			{
				if(s.substring(i-1,i+1).compareTo("10")>=0 &&s.substring(i-1,i+1).compareTo("26")<=0) {
					numEncode[i+1]=numEncode[i-1];
				}
				else 
					return 0;
			}
			
		}
		return numEncode[n];
	}

	//time complexity-O(n)
	//n-length of string
	//space complexity-O(n)
	//dp[n]=dp[n-1]+dp[n-2].
 static int decodeWays(String s) {
	 
	 if(s==null || s.length()==0 || s.charAt(0)=='0')
	        return 0;
	    if(s.length()==1)
	        return 1;
	 
	    int[] dp = new int[s.length()];    
	    dp[0]=1;
	    if(Integer.parseInt(s.substring(0,2))>26) {
	    	if(s.charAt(1)!='0')
	    		dp[1]=1;
	    	else
	    		dp[1]=0;
	    }else {
	    	if(s.charAt(1)!='0') 
	    		//no of ways to represent substring from (0to 2)
	    		dp[1]=2;
	    	else
	    		dp[1]=1;
	    }
	    
	    //starting from the index after 2 i.e substring 0 to 2
	    for(int i=2;i<s.length();i++) {
	    	if(s.charAt(i)!='0')
	    		dp[i]+=dp[i-1];
	    	//sub string from the left of one i.e from i.
	    	int val = Integer.parseInt(s.substring(i-1,i+1));
	    	if(val<=26&&val>=10)
	    		dp[i]+=dp[i-2];
	    	
	    }
	 return dp[s.length()-1];

 }
 }