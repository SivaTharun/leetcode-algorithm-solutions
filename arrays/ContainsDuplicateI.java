package com.arrays.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate 
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
 * @author SivaTharun
 *
 */
public class ContainsDuplicateI {

	public static void main(String[] args) {
		int[] input = {1,5,6,3,5}; 
		System.out.println(containsDuplicateHashing(input));
	}
	
	//brute force method-time complexity-O(n^2)
	static boolean containsDuplicate(int[] input) {
		
		int length = input.length;
		for (int i=0;i<length;i++) {
			for (int j= i+1;j<length;j++) {
				if(input[i]==input[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	//using hasing techinque,using java collections hashset
	//time complexity-O(n)
	static boolean containsDuplicateHashing(int[] input) {
		Set<Integer> inputSet = new HashSet<>();
		for (int i=0;i<input.length;i++) {
			//set add method returns false if set already has that element
			if(!inputSet.add(input[i])) {
				return true;
			}
		}
		return false;
	}
}