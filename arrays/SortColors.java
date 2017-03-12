package com.arrays.practice;

/**
 * 75. Sort Colors
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

	Note:
	You are not suppose to use the library's sort function for this problem.
	A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space? 
 * @author SivaTharun
 *
 */
public class SortColors {

	public static void main(String[] args) {
		
		int input[]=new int[]{1,0,1,2,0,0,1,1,2,2,1};
		int[] output=getSortColorsBucketSortTechnique(input);
		for(int temp:output) {
			System.out.println(temp);
		}
	}
	
	/**
	 * Two pointer technique used for locating and sapping elements 0 and 2 at the extremes of the array.
	 * Time Complexity-O(n)
	 * Space Complexity-O(1) 
	 * 
	 * 
	 */
	static int[] getSortColors(int[] input) {
		int n=input.length;
		//define two pointers to hold the value of 0 and 2 seperately. 
		int low=0;
		int high=n-1;
		
		for(int i=low;i<high;) {
			if(input[i]==0) {
				int temp=input[i];
				input[i]=input[low];
				input[low]=temp;
				low++;i++;
				}
			else if(input[i]==2) {
				int temp=input[i];
				input[i]=input[high];
				input[high]=temp;
				high--;i++;
			}else {
				//for element has 1.
				i++;
			}
			}
		return input;
	}
	
	
	/**
	 * Bucket sorting technique 
	 * @param input
	 * @return
	 */
	static int[] getSortColorsBucketSortTechnique(int[] input) {
		int n= input.length;
		int num0=0,num1=0,num2=0;
		int i=0;
		while(i<n) {
			if(input[i]==0) num0++;
			if(input[i]==1) num1++;
			if(input[i]==2)num2++;
			i++;
		}
		
		int[] output = new int[input.length];
			int k1=0;
			while(k1<num0) {
				output[k1]=0;
				k1++;
			}
			int k2=num0;
			while(k2<num1+num0) {
				output[k2]=1;
				k2++;
			}
			int k3=num0+num1-1;
			while(k3<n) {
				output[k3]=2;
				k3++;
			}
		return output;
	}
}
