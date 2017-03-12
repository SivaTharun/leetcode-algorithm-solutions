package com.arrays.practice;

/**
 *  53. Maximum Subarray 
 *   Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 *  
 * @author SivaTharun
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] input= {-4,-2,-5,-7};
		System.out.println(getMaxValueForDivideAndConquerSubArray(input,0,input.length-1));
	}
	
	/**
	 * Kadenes Algorithm
	 * Time Complexity-O(n)
	 * Space Complexity-O(1)
	 * 
	 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
	 * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
	 * 
	 * Note:
	 * Algorithm doesn't work for all negative numbers. It simply returns 0 if all numbers are negative. For handling this we can add an extra phase before actual implementation. The phase will look if all numbers are negative, if they are it will return maximum of them (or smallest in terms of absolute value).
	 * 
	 */
	static int getMaxSubArrayValue(int[] input) {
		
		int n= input.length;
		
		int max_so_far=0;
		int max_ending_here=0;
		for(int i=0;i<n;i++) {
			if(max_ending_here+input[i]>0) {
				max_ending_here=input[i]+max_ending_here;
			}else {
				//assign curr max value as 0 if sum becomes -ve.
				max_ending_here=0;
			}
			//check if the curr max is greater than max so far.
			if(max_ending_here>0 && max_ending_here>max_so_far) {
				max_so_far=max_ending_here;
			}
		}
		
		return max_so_far;
	}

	/**
	 * DP Solution,Store the max value so far for the corresponding elements
	 * by storing these values in a dp array.
	 * if the sum of previous value and prevoius element >previous element then dp[i]=dp[i-1]+input[i-1]
	 * else dp[i]=input[i-1];
	 * we are emaulating the kadenes algorithm by storing each subsequent element sum in an array.
	 * Note:
	 * This technique works if all input array elements are -ve returns the max negative value in this scenario.
	 * 
	 *  Time Complexity-O(n)
	 *  Space Complexity-O(1)
	 * 
	 */
	static int getMaxValueSubarraySum(int[] input) {
		int[] dp=new int[input.length+1];
		dp[0]=0;
		for(int i=1;i<input.length;i++) {
			dp[i]=Math.max(input[i-1]+dp[i-1], input[i-1]);
		}
		
		int maxSubarrayResult = dp[0];
		
		for(int i=1;i<dp.length;i++) {
			if(maxSubarrayResult<dp[i])
				maxSubarrayResult=dp[i];
		}
		return maxSubarrayResult;
	}
	
	/**
	 * Using Divide and Conquer approach, we can find the maximum subarray sum in O(nLogn) time. Following is the Divide and Conquer algorithm.

1) Divide the given array in two halves
2) Return the maximum of following three
….a) Maximum subarray sum in left half (Make a recursive call)
….b) Maximum subarray sum in right half (Make a recursive call)
….c) Maximum subarray sum such that the subarray crosses the midpoint

The lines 2.a and 2.b are simple recursive calls. How to find maximum subarray sum such that the subarray crosses the midpoint? 
We can easily find the crossing sum in linear time. The idea is simple, find the maximum sum starting from mid point and ending at some point on left of mid, then find the maximum sum starting from mid + 1 and ending with sum point on right of mid + 1. Finally, combine the two and return. 
	 *
	 * 
	 * Time Complexity-O(nLogn)-->since login ids for merge sort technique
	 * Space Complexity-O(1)
	 * 
	 */
	static int getMaxValueForDivideAndConquerSubArray(int[] input,int left,int right) {
		
		if(left==right)
			return input[left];
		int middle=left+(right-left)/2;
	
		/* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half(the left half must include the middle element)
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
		return Math.max(getMaxValue(input, left, middle, right), Math.max(getMaxValueForDivideAndConquerSubArray(input, middle+1, right), getMaxValueForDivideAndConquerSubArray(input,left,middle)));
		
	}
	
	static int getMaxValue(int[] input,int left,int middle,int right) {
	//calculate the max subarray sum for left array
		//assign the left and right sum as min value to get the proper result i.e the max element in the array in case if the input array contains -ve elements.
		int curr_left_sum=Integer.MIN_VALUE;
		int leftsum=0;
		//starting from the middle we can find the continous left sum of the sub array.
		for(int i=middle;i>=left;i--) {
			curr_left_sum=curr_left_sum+input[i];
			if(curr_left_sum>leftsum) 
				leftsum=curr_left_sum;
		}
		
		int curr_right_sum=Integer.MIN_VALUE;
		int rightsum=0;
		//starting from middle+1 we can find the continous right sum of the sub array.
		for(int j=middle+1;j<=right;j++) {
			curr_right_sum=curr_right_sum+input[j];
			if(curr_right_sum>rightsum) {
				rightsum=curr_right_sum;
			}
		}
		return leftsum+rightsum;
	}	
	
}
