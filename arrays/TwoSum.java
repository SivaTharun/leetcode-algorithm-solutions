package com.arrays.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.Two sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * @author SivaTharun
 *
 */
public class TwoSum {
	
	public static void main(String[] args) {
		int [] a = {2, 11,7,15};
		int desiredSum = 9;
		int[] result = twoSumSorted(a, desiredSum);
		for (int current :result) {
			System.out.println(current);
		}
		
	}
	
	//using hashing technique to get the indices of the elements 
	//time complexity - O(n)
	static int[] twoSum(int[] a,int desiredSum) {
	 int n = a.length;
	 int[] result = new int[2];
	 Map<Integer,Integer> sumMap = new HashMap<>();
	 
	 for(int i=0;i<n;i++) {
		 if(sumMap.containsKey(a[i])) {
			 result[0]= sumMap.get(a[i]);
			 result[1] = i;
		 }else {
			 sumMap.put(desiredSum-a[i], i);
		 }
	 }
		
	return result;
	}

	//Method2.using a sorted array
	//Time completixty O(nlogn)(for soting -quicksort) + O(n)
	//O(n^2)-worstcase
	static int[] twoSumSorted(int[] a,int desiredSum) {
		int[] result = new int[2];
		Map<Integer, Integer> twosumMap = new HashMap<>();
		for (int i=0;i<a.length;i++) {
			twosumMap.put(a[i], i);
		}
		Arrays.sort(a);
		int firstIndex=0;
		int lastIndex=a.length-1;
		while(firstIndex<lastIndex) {
			if(a[firstIndex]+a[lastIndex] == desiredSum) {
				result[0]=twosumMap.get(a[lastIndex]);
				result[1]=twosumMap.get(a[firstIndex]);
				break;
			} else if(a[firstIndex]+a[lastIndex] < desiredSum) {
				firstIndex++;
			}
			else {
				lastIndex--;
			}
		}
		return result;
		
	}
}
