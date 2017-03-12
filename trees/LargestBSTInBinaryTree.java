package com.trees.practice;

/**
 * 333.
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
 * where largest means subtree with largest number of nodes in it.
 * 
 * @author SivaTharun
 *
 */
public class LargestBSTInBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root=new BinaryTreeNode();
		root.setData(50);
		BinaryTreeNode left1=new BinaryTreeNode();
		left1.setData(55);
		BinaryTreeNode right1=new BinaryTreeNode();
		right1.setData(70);
		BinaryTreeNode left11=new BinaryTreeNode();
		left11.setData(45);
		BinaryTreeNode left21=new BinaryTreeNode();
		left21.setData(65);
		BinaryTreeNode right21=new BinaryTreeNode();
		right21.setData(80);
		right1.setLeftNode(left21);
		right1.setRightNode(right21);
		left1.setLeftNode(left11);
		root.setLeftNode(left1);
		root.setRightNode(right1);
		System.out.println(largestBST(root));
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 * 
	 */
	public static int largestBST(BinaryTreeNode root) {
		BSTChecker bstChecker=findLargestBSTSubtree(root);
		return bstChecker.size;
	}
	
	
	public static BSTChecker findLargestBSTSubtree(BinaryTreeNode root) {
		//if this a null node for a leaf then send a new object,as this size is 0
		if(root==null)return new BSTChecker();
		
		BSTChecker currentBstChecker=new BSTChecker();
		//this is a post order traversal,first visit the left subtree and then the right
		//use the information obtained to calculate the largest bst in the subtree.
		BSTChecker leftbstChecker=findLargestBSTSubtree(root.getLeftNode());
		BSTChecker rightbstChecker=findLargestBSTSubtree(root.getRightNode());
		
		//if either the left or right subtree is not a bst then this root tree will not be an bst,hence the size of the bst will be 
		//the max of either the left or right subtree
		if(!leftbstChecker.isBst||!rightbstChecker.isBst||root.getData()<leftbstChecker.max||root.getData()>rightbstChecker.min) {
			currentBstChecker.size=Math.max(leftbstChecker.size, rightbstChecker.size);
			currentBstChecker.isBst=false;
			return currentBstChecker;
		}
		//this condition id for if both the left and right subtrees are a bst
		if (leftbstChecker.isBst && rightbstChecker.isBst) {
			//the size of bst will be the sum of left and right subtree +1(including the root also)
			currentBstChecker.size = 1 + leftbstChecker.size + rightbstChecker.size;
			currentBstChecker.isBst = true;
		}
		
		//if the left node is not null,then 
		//the min value for this will be the min value of the leftsubtree
		if(root.getLeftNode()!=null)
			currentBstChecker.min=leftbstChecker.min;
		else
			currentBstChecker.min=root.getData();
		//if the right node is not null then the max value for this tree
		//will be the max value of right subtree
		if(root.getRightNode()!=null)
			currentBstChecker.max=rightbstChecker.max;
		else
			currentBstChecker.max=root.getData();
		
		return currentBstChecker;
		
	}
	public static class BSTChecker {
		
		int min;
		int max;
		boolean isBst;
		int size;
		
		public BSTChecker() {
			this.min=Integer.MAX_VALUE;
			this.max=Integer.MIN_VALUE;
			this.isBst=true;
			this.size=0;
		}
	}

}
