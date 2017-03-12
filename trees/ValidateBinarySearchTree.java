package com.trees.practice;

import java.util.Stack;

/**
 *  98. Validate Binary Search Tree 
 *   Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

	Example 1:

    2
   / \
  1   3

  Binary tree [2,1,3], return true. 
 * @author SivaTharun
 *
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {

		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(8);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(3);
		BinaryTreeNode leftNode11 = new BinaryTreeNode();
		leftNode11.setData(1);
		leftNode1.setLeftNode(leftNode11);
		
		BinaryTreeNode rightNode11 = new BinaryTreeNode();
		rightNode11.setData(6);
		leftNode1.setRightNode(rightNode11);
		root1.setLeftNode(leftNode1);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(10);
		BinaryTreeNode leftNode12 = new BinaryTreeNode();
		leftNode12.setData(9);
		rightNode1.setLeftNode(leftNode12);
		
		BinaryTreeNode rightNode12 = new BinaryTreeNode();
		rightNode12.setData(14);
		rightNode1.setRightNode(rightNode12);
		root1.setRightNode(rightNode1);
	
		//System.out.println(isValidBSTRange(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(isValidBSTInorderTraversal(root1));
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(BinaryTreeNode root) {
       if(root==null)
		return true;
       return isValidBSTHelper(root);
		
    }

	/**
	 * Need to work on the case in which value of the nodes is larger or smaller than that of the root node.
	 * 
	 */
	public static boolean isValidBSTHelper(BinaryTreeNode root) {
		
		int data=root.getData();
		boolean leftFlag=false;
		boolean rightFlag=true;
		BinaryTreeNode leftNode=null;
		BinaryTreeNode rightNode=null;
		leftNode=root.getLeftNode();
		rightNode=root.getRightNode();
		if(leftNode!=null) {
			if(leftNode.getData()<=data)leftFlag=true;
		}else if(leftNode==null) {
			leftFlag=true;
		}
		if(rightNode!=null) {
			if(rightNode.getData()>data)rightFlag=true;
		}else if(rightNode==null) {
			rightFlag=true;
		}
		
		if(leftFlag&&rightFlag) {
			if(leftNode==null&&rightNode==null) {
				return true;
			}else if(leftNode==null)
				return true&&isValidBSTHelper(root.getRightNode());
			else if(rightNode==null)
				return true&&isValidBSTHelper(root.getLeftNode());
			//if both left and right trees are not empty
			return true&&isValidBSTHelper(root.getLeftNode())&&isValidBSTHelper(root.getRightNode());
		} else {
			return false;
		}
	}
	
	/**
	 * Time Complexity-O(n)-->since each node is traversed only once.
	 * Space Complexity-O(n)-->since the method is called upon each node twice for both left and right sub trees.
	 * 
	 */
	public static boolean isValidBSTRange(BinaryTreeNode root,int nodeMin,int nodeMax) {
		//base condition for which 
		//the leaf node is always a balanced BST.
		//this condition will arise when all the parents in this path satisfy 
		if(root==null)
			return true;
		if(root.getData()>nodeMin&&root.getData()<nodeMax) {
			return isValidBSTRange(root.getLeftNode(), nodeMin, root.getData())&&isValidBSTRange(root.getRightNode(), root.getData(), nodeMax);
		} else
			return false;
	}
	
	/**
	 * Time Complexity-O(n)
	 * 
	 * Since the in order traversal of a BST is in increasing order,when compared to
	 * previous elements,so compare with the previous element in the BST in order traversal
	 * and return boolean result. 
	 * 
	 */
	public static boolean isValidBSTInorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return true;
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode prev = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.getLeftNode();
			}
			root = stack.pop();
			if (prev != null && root.getData() < prev.getData())
				return false;

			prev = root;
			root = root.getRightNode();
		}
		return true;
	}
}
