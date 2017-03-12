package com.math.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  368. Largest Divisible Subset 
 *   Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

	If there are multiple solutions, return any subset is fine.

	Example 1:

	nums: [1,2,3]

	Result: [1,2] (of course, [1,3] will also be ok)

	Example 2:

	nums: [1,2,4,8]

	Result: [1,2,4,8]

 *
 */
public class LargestDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,2,3};
		System.out.println(getLargestDivisibleSubset(input));
	}
	
	static ArrayList<Integer> getLargestDivisibleSubset(int[] input) {
		   boolean[] boolInput = new boolean[input.length];
		   Arrays.sort(input);
		   ArrayList<Integer> al = new ArrayList<>();
		   
		   for(int i=0;i<input.length;i++) {
			   for(int j=i+1;j<input.length;j++) {
				   if(input[i]%input[j]==0 ||input[j]%input[i]==0) {
					   boolInput[i]=true;
					   boolInput[j]=true;
				   }
			   }
		   }
		   
		   for(int k=0;k<boolInput.length;k++) {
			   if(boolInput[k])
				   al.add(input[k]);
		   }
		return al;
	}

}
