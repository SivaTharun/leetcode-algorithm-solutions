package com.arrays.practice;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
 * @author SivaTharun
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] input={1,1,3,5,6};
		int target=7;
		System.out.println(getInsertPosition(input, target));
		
	}
	
	/**
	 * Using binary Search technique since the array is sorted.
	 * 
	 * Time Complexity-O(logn)
	 * Space Complexity-O(1)
	 *  
	 * @param input
	 * @param target
	 * @return
	 */
	static int getInsertPosition(int[] input,int target) {
		int n=input.length-1;
		int low=0;
		int high=n-1;
        // Invariant: the desired index is between [low, high+1]-->in the scenario in which the element is greater that the last element
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(input[mid]==target)
				return mid;
			else if(input[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		// (1) At this point, low > high. That is, low >= high+1
        // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Following from (1), now we know low == high+1.
        // (3) Following from (2), the index is between [low, high+1] = [low, low],this will happen iff high+1=low, which means that low is the desired index
        //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
		return low;
	}
	
	

}
