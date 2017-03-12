package com.trees.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal 
 *  
 * Given a binary tree, return the preorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},

   	1
     \
      2
     /
    3
   return [1,2,3]. 
 *
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		BinaryTreeNode RightNode1=new BinaryTreeNode();
		RightNode1.setData(2);
		BinaryTreeNode LeftNode11=new BinaryTreeNode();
		LeftNode11.setData(3);
		RightNode1.setLeftNode(LeftNode11);
		root1.setRightNode(RightNode1);
		System.out.println(preorderTraversalFancyIterative(root1));
	}

	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)
	 * 
	 * 1)push root to the stack
	 * 2)iterate through the stack and pop the top of stack
	 * 3)print/put the data from the popped item.
	 * 4)push the right node of the popped item onto the stack.
	 * 5)push the left node of the popped item onto the stack.
	 * 6)repeat from step2 till the stack is empty
	 */
	public static List<Integer> preorderTraversal(BinaryTreeNode root) {
	
		List<Integer> result=new ArrayList<>();
		if(root==null)return result;
		Stack<BinaryTreeNode> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode curr=stack.pop();
			result.add(curr.getData());
			//push right node on top of stack
			if(curr.getRightNode()!=null)
				stack.push(curr.getRightNode());
			//push left node on top of the stack
			if(curr.getLeftNode()!=null)
				stack.push(curr.getLeftNode());
		} 	
		return result;
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)-->height of the tree
	 * 
	 */
	public static List<Integer> preorderTraversalFancyIterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		List<Integer> result=new ArrayList<>();
		if(root==null)return result;
		while(!stack.isEmpty()||root!=null) {
			//base condition to push the elements on to the list
			if(root!=null) {
				result.add(root.getData());
				//pushing only right nodes onto the stack
				stack.push(root.getRightNode());
				//iterate the left node of current node to root.getLeftNode()
				root=root.getLeftNode();
			}else {
				root=stack.pop();
			}
		}
		return result;
	}
}
