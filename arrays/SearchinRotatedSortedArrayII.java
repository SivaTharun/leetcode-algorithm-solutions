package com.arrays.practice;

/**
 * 81. Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?

	Would this affect the run-time complexity? How and why?

	Write a function to determine if a given target is in the array.
 * 
 *
 */
public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		int[] input = new int[]{4,4,5,6,7,7,0,1,1,2,2};
		
		int target=6;
		System.out.println(searchinRotatedSortedArrayWithDup(input, target));
	}
	
	/**
	 * Time Complexity-O(n)-->worst case time complexity when input array is like [111112]-->we have to go on increamenting the 
	 * low pointer continously.
	 * Space Complexity-O(n)
	 * 
	 * 
	 */
	static boolean searchinRotatedSortedArrayWithDup(int[] input,int target) {
		
		int n=input.length;
		int low=0,high=n-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(input[mid]==target) {
				return true;
			}
			//the first half of array is not rotated
			//perform divide and conquer technique here
			else if(input[low]<input[mid]) {
				if(input[low]<=target&&input[mid]>target) {
					high=mid-1;
				}else {
					low=mid+1;
				}
			}
			//the first half of array is rotated
			//perform divide and conquer technique here
			else if(input[low]>input[mid]) {
				if(input[high]>=target&&target>input[mid]) {
					low=mid+1;
				}else {
					high=mid-1;
				}
			}
			//duplicate elements found. 
			//if(input[mid]==input[low]||input[mid]==input[high])
			else  {
				//duplicates, we know input[mid] != target, so input[start] != target
	            //based on current information, we can only move left pointer to skip one cell
	            //thus in the worst case, we would have target: 2, and array like 11111111, then
	            //the running time would be O(n).
				//when input[mid] == input[left], you cannot guara	ntee the shape of array.
				low++;
			}
		}
		return false;
	}
}
