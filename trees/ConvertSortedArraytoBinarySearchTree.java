package com.trees.practice;

/**
 * 108. Convert Sorted Array to Binary Search Tree 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 *  
 * @author SivaTharun
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		
		int[] nums={1,2,3,4}; 
		BinaryTreeNode root=sortedArrayToBST(nums);
		System.out.println(root);
	}
	
	public static BinaryTreeNode sortedArrayToBST(int[] nums) {
		
		return sortedArrayToBSTHelper(0, nums.length-1, nums);
		
	}
	
	/**
	 * Time Complexity-O(n)-->since the middle element of the array is calculated in constant time.
	 * Space Complexity-O(n)-->since the value for each root is to be made a recursive call.
	 * 
	 */
	public static BinaryTreeNode sortedArrayToBSTHelper(int start,int end,int[] nums) {
		//base condition for the nodes of leaf nodes which are to be null
		if(start>end)
			return null;
		int mid=(start+end)/2;
		BinaryTreeNode root=new BinaryTreeNode();
		root.setData(nums[mid]);
		root.setLeftNode(sortedArrayToBSTHelper(start, mid-1, nums));
		root.setRightNode(sortedArrayToBSTHelper(mid+1, end, nums));
		return root;
	}

}
