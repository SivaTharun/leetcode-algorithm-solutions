package com.arrays.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 80. Remove Duplicates from Sorted Array II 
 *  Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. 
 * @author SivaTharun
 *
 */
public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		int[] input=new int[]{1,1,1,2,2,3};
		System.out.println(removeDuplicatesInPlace(input));
	}
	
	/**
	 * TIme Complexity-O(n)
	 * Space Complexity-O(n)
	 * @return
	 */
	static int removeDuplicates(int[] input) {
		int recentDupElement = Integer.MIN_VALUE;
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<input.length;i++) {
			if(i!=input.length-1&&input[i]==input[i+1]) {
				//skip the element if the element is already present in the list.
				//but will add the second duplicate if we compare 
				if(recentDupElement!=input[i]) {
					result.add(input[i]);
					recentDupElement=input[i];
				}else {
					continue;
				}
			}else 
			{
				//corner case is satisfied if the input is {1,1,1} and so on.since the above condition is skipped for last index of the input.
				result.add(input[i]);
			}
			
		}
		return result.size();	
	}
	
	//Time Complexity-O(n)
	//space Complexity-O(1)
	static int removeDuplicatesInPlace(int[] input) {
		int idx=0;
		int count=0;
		for(int i=0;i<input.length;i++) {
			if(i!=0&&input[i]==input[i-1]) {
				count++;
				if(count>=3)
					continue;
			}else {
				//if not equal then put count as 1.
				count=1;
			}
			input[idx++]=input[i];
		}
		return idx;
	}
}
