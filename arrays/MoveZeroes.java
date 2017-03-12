package com.arrays.practice;

/**
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
 * 	@author SivaTharun
 *
 */
public class MoveZeroes {
	
	//Time complexity-O(n)
	static void pushZeroesToEnd(int[] arr) {
	
		int nonZeroElementsCount = 0;
		
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arr[nonZeroElementsCount++]= arr[i];
			}
		}
		while (nonZeroElementsCount <arr.length) {
			arr[nonZeroElementsCount++] = 0;
		}
		
	}
	
	//method 2:using two pointers variables for zero and non zero elements
	//time complexity-O(n)
	static void pushZerosUsingTwoVaraibales(int[] arr) {
		int i=0,j=0;
		while (j<arr.length) {
			if(arr[j]==0) {
				//loop incremental
				j++;
			}else {
				//assigning non zeros to the front
				arr[i] = arr[j];
				i++;
				//loop incremental
				j++;
			}
		}
		while (i<arr.length) {
			arr[i++] = 0;
		}
	}
	
	public static void main(String[] args) {
		int arr[] ={1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		pushZerosUsingTwoVaraibales(arr);
		System.out.println("The array elements after pushing zeroes to end");
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
