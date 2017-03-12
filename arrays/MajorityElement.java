package com.arrays.practice;

import java.util.Arrays;

/**
 * 169. Majority Element 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than  n/2 times.You may assume that the array is non-empty and the majority element always exist in the array.
 * @author SivaTharun
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={3 ,3 ,4 ,2,4 ,4,4,4,4,3,4,5,6};
		System.out.println(majorityElementUsingSorting(a));

	}
	
	//time complexity-O(nlogn)+O(n)
	//space complexity-O(1)
	static int majorityElementUsingSorting(int[] a) {
		//Note:since after sorting the array the majority element should occupy the index at n/2,so the element at n/2 will be the ,majority index,bu this case fails if
		//the test case has no majority element,the result would be a random element as output.
		Arrays.sort(a);
		int count=1;
		int prev=a[0];
		for (int i=1;i<a.length;i++) {
			if(a[i]==prev) {
				count++;
				if(count>a.length/2) 
				return a[i]; 
			}
			else 
			{
				prev = a[i];
				count =1;
			}
		}
		return -1;
	}
	
	//time complexity-O(n)
	//space complexity-O(1)
	static int majorityElementUsingMooresVotingAlgorithm(int[] a) {
		//first select a candidate element as a majority element
		int majorityIndex=0;int count =1;
		
		for (int i=1;i<a.length;i++) {
			if(a[i]==a[majorityIndex]) {
				count++;
			}
			else {
				count--;
			}
			//if the count becomes zero then take the majority element as current element and reset count to 1.
			if(count==0) {
				majorityIndex=i;
				count=1;
			}
		}
		//check whether the select candidate is indeed a majority element
		int majorityElementCount=0;
		for (int j=0;j<a.length;j++) {
			if(a[j]==a[majorityIndex]) {
				majorityElementCount++;
				if(majorityElementCount>a.length/2) {
					return a[majorityIndex];
				}
			}
		}
		return -1;
	}
}

