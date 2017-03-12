package com.strings.practice;

import java.util.ArrayList;

/**
 * 22. Generate Parentheses
 * 
 * 
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * @author SivaTharun
 *
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		int noOfLevelsofParentheses=3;
		ArrayList<String> al = new ArrayList<>();
		String s= "";
		generateParanthesesUsingRecursion(al, s, noOfLevelsofParentheses, noOfLevelsofParentheses);
		for(String temp:al) {
			System.out.println(temp);
		}
	}
	
	//using recursion(or explicit stack/Similar to DFS technique in graphs) to try all the valid combinations for the parantheses.
	/**
	 *
	 *  Time Complexityy-2^(n-1)(or)2^n.
	 *	if you trace the program and examine function call stack for n=1,2,3..
	 *	You will come to know 2!(n-1) recursive calls are made to the method.
	 *	space complexity-No of recursive calls -n! calls
	 *	Actual time complexity-O(n!).First let’s assume there is no valid parentheses rule. 
	 *	For each position we can either place ( or ) . Running time would be 2^n . 
	 *	Since there is rule, once we put ( in the place , the next position will be limited. So it is n! . 
	 * 
	 */
	static void generateParanthesesUsingRecursion(ArrayList<String> al,String s,int left,int right) {
		
		//check for remaining braces as left braces are always the majority or equal to that of right bracets in a valid parentheses.
		//ex:(()-->here left brackets=2,and right bracket=1(majority scenario)
		//(())-->here left & right brackets =2.(equal) 
		if(left>right)
			return;
		//if all the braces are used up(valid combination)
		if(left==0&&right==0) {
			al.add(s);
			return;
		}
		if(left>0) {
			generateParanthesesUsingRecursion(al, s+"(", left-1, right);
		}
		if(right>0) {
			generateParanthesesUsingRecursion(al, s+")", left, right-1);
		}
	}
	
}
