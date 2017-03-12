package com.arrays.practice;

/**
 * 55. Jump Game
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false. 
 * @author SivaTharun
 *
 */
public class JumpGame {

	public static void main(String[] args) {
		
		int[] input={2,3,1,1,4};
		System.out.println(isLastValueReacheable(input));
	}
	
	/**
	 * Greedy Algorithm
	 * Time Complexity-O(n)
	 * Space COmplexity-O(1)
	 * 
	 */
	static boolean isLastValueReacheable(int[] input) {
		//always calculate the max step value for each element -->a greedy algorithm
		int maxStep=0;
		for(int i=0;i<input.length-1;i++) {
			if(i+input[i]>maxStep)
			{
				maxStep=i+input[i];
			}
			//case when the current array element is 0
			else if(maxStep<i) {
				return false;
			}
		}
		if(maxStep>=input.length-1)
			return true;
		else 
			return false;
	}
	
	/**
	 * DP programming based algorithm.
	 * maintaining a seperate boolean array to check whether that element is reacheable or not
	 * 
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 * @return
	 */
	static boolean isLastReacheable(int[] input) {
		int n= input.length;
		//hold the value of max reach of last but one element as the size of boolean array.
		boolean[] b = new boolean[n-2+input[n-1]];
		if(input==null || input.length==0)
				return false;
		if(input[0]==0)
			return false;
		b[0]=true;
		for(int i=0;i<input.length-1;i++) {
			//check whether the current element is reacheable or not 
			if(b[i]) {
				for(int j=1;j<=input[i];j++) {
					b[i+j]=true;
				}
			}
		}
		return b[input.length-1];
	}

}
