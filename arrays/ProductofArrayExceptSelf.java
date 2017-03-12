package com.arrays.practice;

/**
 *   238. Product of Array Except Self 
 *  Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

	Solve it without division and in O(n).

	For example, given [1,2,3,4], return [24,12,8,6].

	Follow up:
	Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author SivaTharun
 *
 */
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] input=new int[]{1,2,3,4};
		int[] output=getProductExceptSelf(input);
		for(int temp:output) {
			System.out.println(temp);
		}
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 *  Algorithm:
	 *	1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i] excluding arr[i].
	 *	2) Construct another temporary array right[] such that right[i] contains product of all elements on on right of arr[i] excluding arr[i].
	 *	3) To get prod[], multiply left[] and right[].
	 * 
	 */
	static int[] getProductOfArrayExceptSelf(int[] input) {
		
		//initailize the left array
		int[] left = new int[input.length];
 		
		//initialize the right array
		int[] right = new int[input.length];
		
		int[] prod=new int[input.length];
		
		int n= input.length;
		
		left[0]=1;
		
		right[n-1]=1;
		
		for(int i=1;i<n;i++) {
			left[i]=left[i-1]*input[i-1];
		}
		
		for(int j=n-2;j>=0;j--) {
			right[j]=right[j+1]*input[j+1];
		}
		
		for(int i=0;i<n;i++) {
			prod[i]=left[i]*right[i];
		}
		
		return prod;
	}
	
	/**
	 * Time Complexity-O(n)
	 * Auxillary Space Complexity-O(1)-->bcoz we are not using any intermediate array to store left and right product seperately.
	 * 
	 */
	static int[] getProductExceptSelf(int[] input) {
		int[] product=new int[input.length];
		int n= input.length;
		//first store the right product
		product[n-1]=1;
		for(int i=n-2;i>=0;i--) {
			product[i]=product[i+1]*input[i+1];
		}
		//for first element in the array the product for itself is 1 from the left.
		int temp=1;
		for(int j=0;j<n;j++) {
			product[j]=product[j]*temp;
			//compute the temp for the next product element.
			temp=temp*input[j];
		}
		return product;
	}
}
