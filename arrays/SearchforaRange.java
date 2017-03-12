package com.arrays.practice;

/**
 * 34. Search for a Range
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
 * @author SivaTharun
 *
 */
public class SearchforaRange {

	public static void main(String[] args) {
		int[] input={0,1,2,3};
		int target=8;
		System.out.println(getRangeUsingBinarySearch(input, target));
	}
	
	/**
	 * Time Complexity-worst case scenario-->when all elements are equal-->O(nlogn)
	 * Space Complexity-O(1)
	 * @param input
	 * @param target
	 * @return
	 */
	static int[] getRange(int[] input,int target) {
	
		int n=input.length-1;
		int low=0;
		int high=n;
		int[] result = {-1,-1};
		while(low<=high) {
			int mid= low+(high-low)/2;
			if(input[mid]==target) {
				result[0]=mid;
				result[1]=mid;
				int i=mid-1;
				int j=mid+1;
				while(i>=0) {
					if(input[i]==target) {
						result[0]=i;
					}
					i--;
				}
				while(j<=n) {
					if(input[j]==target) {
					result[1]=j;
					}
					j++;
				}
				break;
			} else if(input[mid]>target) {
				high=mid-1;
			} else {
				low=mid+1;
			}
			
		}
		return result;		
	}
	
	/**
	 * 
	 * 
	 */
	static int firstOccurenceHelper(int[] input, int target) {
		int low=0;
		int high=input.length;
		while(low<high) {
			int mid=low+(high-low)/2;
			if(input[mid]<target) {
				low=mid+1;
			} else{
				//case I:if input[mid]==target,high=mid-->catches the first occurence
				//case II:if input[mid]>target,high=mid-1;
				//combining the above cases,we have
				
				/**
				 * For the right of the range, we can use a similar idea. Again we can come up with several rules:

    If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
    If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
    If A[mid] = target, then the range must begins on the right of or at mid (i= mid)

Again, we can merge condition 2 and 3 into:

2* If A[mid] <= target, then i = mid;

				 */
				high=mid;
			}
			
		}
		return low;
	}
	
	/**
	 * Time Complexity-O(logn)
	 * 
	 * 
	 * 
	 */
	static int[] getRangeUsingBinarySearch(int[] input,int target) {
		//get the first instance of occurence of the element
		int n=input.length;
		int start=firstOccurenceHelper(input, target);
		//the binary helper returns low=n when element is not present in the array.
		if(start==n ||input[n-1]!=target) {
			return new int[]{-1,-1};
		}
		//the end index of the range can be obtained by using the helper method,using the target as target+1 and remove one index
		//which gives the last index of target.
		return new int[]{start,firstOccurenceHelper(input,target+1)-1};
	}

}
