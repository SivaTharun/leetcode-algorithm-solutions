package com.trees.practice;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *  For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1. 
 * @author SivaTharun
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		BinaryTreeNode leftNode11 = new BinaryTreeNode();
		leftNode11.setData(3);
		leftNode1.setLeftNode(leftNode11);
		
		BinaryTreeNode rightNode11 = new BinaryTreeNode();
		rightNode11.setData(3);
		leftNode1.setRightNode(rightNode11);
		root1.setLeftNode(leftNode1);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(2);
		BinaryTreeNode leftNode12 = new BinaryTreeNode();
		leftNode12.setData(3);
		rightNode1.setLeftNode(leftNode12);
		
		BinaryTreeNode rightNode12 = new BinaryTreeNode();
		rightNode12.setData(3);
		rightNode1.setRightNode(rightNode12);
		root1.setRightNode(rightNode1);
	
		
		//System.out.println(balancedDriver(root1));
		
		if(balancedTreeHeightChecker(root1)!=-1)
			System.out.println(true);
		else
			System.out.println(false);
	}
	
	
	public static int getHeight(BinaryTreeNode root) {
		if(root==null)
			return 0;
		else 
			return 1+Math.max(getHeight(root.getLeftNode()), getHeight(root.getRightNode()));
	}
	
	/**
	 * optimized recursive solution--> using the same driver method to calculate the height of the tree.
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 *  
	 */
	public static int balancedTreeHeightChecker(BinaryTreeNode root) {
		
		if(root==null)
			return 0;
		int left=balancedTreeHeightChecker(root.getLeftNode());
		int right=balancedTreeHeightChecker(root.getRightNode());
		//extra condition to check for whether the tree is balanced or not
		if(left==-1 || right==-1)
			return -1;
		//base condition for tree balance check for both left and right subtree.
		if(Math.abs(left-right)>1)
			return -1;
		//same condition to get the tree height  
		return 1+Math.max(left, right);
		
	}
	
	/**
	 *
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)-->for implicit stack
	 * 
	 */
	public static boolean balancedDriver(BinaryTreeNode root) {
		
	if(root==null)
		//returning true for empty tree nodes 
		return true;
		int left=getHeight(root.getLeftNode());
		int right=getHeight(root.getRightNode());
		//base condition for left and right subtree height check
		if(Math.abs(left-right)>1) {
			return false;
		}
		return balancedDriver(root.getLeftNode())&&balancedDriver(root.getRightNode());
		
	}

	/*public static boolean isBalanced(BinaryTreeNode root) {
	 
		if(root==null)
			return false;
		else
		{ 
			if(root.getLeftNode()!=null && root.getRightNode()!=null) {
			int leftHeight=1+balancedDriver(root.getLeftNode());
			int rightHeight=1+balancedDriver(root.getRightNode());
			if(Math.abs(leftHeight-rightHeight)<=1)
				return true;
			return false;
			}else if(root.getLeftNode()==null && root.getRightNode()==null) {
				return true;
			} else if(root.getLeftNode()==null && root.getRightNode()!=null) {
				int rightHeight=1+balancedDriver(root.getRightNode());
			}
		}
	}*/
	
	/*public static int balancedDriver(BinaryTreeNode root) {
		if(root==null)
			return 0;
		else{
			return 1;
		}
		
	}*/
}
