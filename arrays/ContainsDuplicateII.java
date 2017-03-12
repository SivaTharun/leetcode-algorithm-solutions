package com.arrays.practice;

import java.util.HashMap;
import java.util.Map;

/**
 *  219. Contains Duplicate II
 *  Given an array of integers and an integer k, 
 *  find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
 * @author SivaTharun
 *
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		int [] a = {1,3,4,5,8,3};
		int limit =3;
		System.out.println(containsDuplicate(a, limit));
	}
	
	//using hashing technique to calculate the indices of duplicate elements 
	static boolean containsDuplicate(int[] a, int limit) {
		Map<Integer,Integer> elementMap = new HashMap<>();
		boolean flag = false;
		int length = a.length;
		for (int i =0;i<length;i++) {
			if(elementMap.containsKey(a[i])) {
				int first = elementMap.get(a[i]);
				int second = i;
				if(Math.abs(first-second)<=limit) {
					flag = true;
				}
			}else {
				elementMap.put(a[i], i);
			}
		}
		return flag;
	}

}
