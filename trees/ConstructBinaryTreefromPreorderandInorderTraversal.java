package com.trees.practice;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree. 
 * @author SivaTharun
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		//for worst case for left skewed tree
		/**
		 * int[] inorder={4,3,2,1};
		   int[] preorder={1,2,3,4};
		 */
		int[] inorder={4,2,5,1,6,7,3,8};
		int[] preorder={1,2,4,5,3,7,6,8};
		BinaryTreeNode root=buildTree(preorder, inorder);
		
	}
	
	public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
		
		return buildHelper(preorder, inorder, 0, 0, inorder.length-1);
	}
	
	/**
	 * Time Complexity-O(NlogN)-->in case of complete binary tree since,root will be middle element and the for loop time complexity reduces by logn-->for n elements
	 *-->O(N^2)-->in case of left skewed tree since the root will always be the last element in the in order array-->so this is done for n elements.
	 *-->O(N)-->for right skewed tree since the root will be the first element in the inorder array
	 *Space Complexity-O(N)-->since for each element the helper is called upo once
	 * 
	 */
	public static BinaryTreeNode buildHelper(int[] preorder,int[] inorder, int preorderstart,int inorderstart,int inorderend) {
		
		if(preorderstart>preorder.length-1||inorderstart>inorderend)
			return null;
		BinaryTreeNode root=new BinaryTreeNode();
		root.setData(preorder[preorderstart]);
		//get the index of the root from in order list
		int boundaryIndex=-1;
		
		//time complexity due to iteration in this for loop to get the root index in in order list
		//to reduce time complexity due to this iteration,introduce as hashmap with key as the element value and its position in inorder as the value
		for(int i=inorderstart;i<=inorderend;i++) {
			if(root.getData()==inorder[i]) {
				boundaryIndex=i;
				break;
			}
		}
		//get the number of elements on the left  half of in order array
		int numElementsOnLeft=boundaryIndex-inorderstart;
		//pick the next element as the root in pre order list
		root.setLeftNode(buildHelper(preorder, inorder, preorderstart+1, inorderstart, boundaryIndex-1));
		//pick the element after the left sub tree elements start as the root for right sub tree
		root.setRightNode(buildHelper(preorder, inorder, preorderstart+1+numElementsOnLeft, boundaryIndex+1, inorderend));
		return root;
	}
}
