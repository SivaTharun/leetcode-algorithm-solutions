package com.arrays.practice;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {9,8};
		int [] result = plusOne(input);
		for (int current :result)
			System.out.println(current);

	}
	
	//Time complexity-O(n),space complexity-O(n)
	//The problem with converting the integer array to a number is that that for a very large 
	//array the data type for the result is unknown.
	//instead perform the operation of adding the numbers at each index by adding the corresponding carry from the previous index calculation
	static int[] plusOne(int[] input) {
		int n= input.length;
		int[] result = new int[n];
		//intialize carry as 1 since we need to add 1.
		int carry =1;
		int sum =0;
		for (int i=n-1;i>=0;i--) {
			sum = input[i]+carry;
			result[i]=sum%10;
			carry = sum/10;
		}
		//a new didgit to be added to the result infront
		if(carry==1) {
			int[] reformedResult = new int[n+1];
			int i=0;
			int j=1;
			while(j<reformedResult.length) {
				reformedResult[j++]=result[i++];
			}
			reformedResult[0]=1;
			return reformedResult;
		}
		return result;
	}

}
