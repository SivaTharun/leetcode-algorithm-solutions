package com.trees.practice;

import java.util.Stack;

/**
 *  404. Sum of Left Leaves 
 *  
 *  Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 *   
 *
 */
public class SumofLeftLeaves {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(3);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(9);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(20);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(4);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(5);
		//leftNode1.setLeftNode(leftNode11);
		//leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(15);
		
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(7);
		rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		
		System.out.println(getLeftLeavesSum(root1));
	}

	/**
	 * Recursive Solution.
	 * @param root
	 * @return
	 */
	public static int sumOfLeftLeaves(BinaryTreeNode root) {
		
		int res=0;
		if(root==null)
			return res;
		return leftLeavesSumHelper(root);
	}
	
	/**
	 * Recursive solution
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)
	 * @return
	 */
	public static int leftLeavesSumHelper(BinaryTreeNode root) {
		if(root==null)return 0;
		int res=0;
		
		//add the left most leaf node if there is one from the current node 
		if(root.getLeftNode()!=null) {
			if(root.getLeftNode().getLeftNode()==null&&root.getLeftNode().getRightNode()==null)
				res+=root.getLeftNode().getData();
			else
				res+=leftLeavesSumHelper(root.getLeftNode());
		}
		//get the left most leaf node for the current right node
		if(root.getRightNode()!=null) {
			res+=leftLeavesSumHelper(root.getRightNode());
		}
		return res;
	}
	
	/**
	 * Iterative Solution
	 * 
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 */
	public static int getLeftLeavesSum(BinaryTreeNode root) {
		if(root==null)return 0;
		int res=0;
		Stack<BinaryTreeNode> stack= new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode current=stack.pop();
			if(current!=null) {
				if(current.getLeftNode()!=null) {
					if(current.getLeftNode().getLeftNode()==null&&current.getLeftNode().getRightNode()==null) {
						res+=current.getLeftNode().getData();
					} else {
						stack.push(current.getLeftNode());
					}
				}
				if(current.getRightNode()!=null) {
					stack.push(current.getRightNode());
				}
			}
			
		}
		return res;
	}	
}
