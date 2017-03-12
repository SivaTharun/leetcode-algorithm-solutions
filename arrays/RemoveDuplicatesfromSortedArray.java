package com.arrays.practice;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory. 
 * @author SivaTharun
 *
 */
public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,1,1,2,2,3};
		System.out.println(RemoveDuplicatesUsingTwoPointers(input));
	}
	
	//since this is an in-place duplicate removal technique,we can not use hashing here so,we use two pointer technique to push the unique elemnts to  the font of the array.
	static int RemoveDuplicatesUsingTwoPointers(int[] input) {
		int length = input.length;
		//pointer 1 to store the original index
		int i=0;
		//pointer 2 to store the next index for comparing duplicates
		int j=1;
		while(j<length) {
			if(input[i]==input[j])
				//continue with the next element
				j++;
			else {
				i++;
				input[i]=input[j];
				j++;
			}
		}
		
		return i+1;
	}

}
