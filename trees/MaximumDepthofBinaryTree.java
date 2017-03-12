package com.trees.practice;

import java.util.Stack;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author SivaTharun
 *
 */
public class MaximumDepthofBinaryTree {

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
		
		System.out.println(getMaxDepthIterative(root1));
		
	}
	
	/**
	 * Post Order traversal iterative depth of tree calculation
	 * Time Complexity-O(logn)
	 * Space Complexity-O(logn)
	 */
	public static int getMaxDepthIterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> nodeStack = new Stack<>();
		nodeStack.push(root);
		int maxDepth=0;
		
		BinaryTreeNode prev= null;
		while(!nodeStack.isEmpty()) {
			BinaryTreeNode curr=nodeStack.peek();
			if(prev==null ||prev.getLeftNode()==curr||prev.getRightNode()==curr) {
				if(curr.getLeftNode()!=null) {
					nodeStack.push(curr.getLeftNode());
				}else if(curr.getRightNode()!=null) {
					nodeStack.push(curr.getRightNode());
				}
				
			//it is executed if the current node is root and the left subtree is completely popped
			//start pushing the right sub tree
			} else if(curr.getLeftNode()==prev) {
				if(curr.getRightNode()!=null) {
					//right node becomes the root node of the tree an continue with the Post order traversal.
					nodeStack.push(curr.getRightNode());
				}
			}else {
				//start popping out the elements if end of a sub tree is reached.
				 nodeStack.pop();	
				}
			//assign the curr value to prev value.
			prev=curr;
			if(nodeStack.size()>maxDepth)
				maxDepth=nodeStack.size();
		}
		return maxDepth;
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public static int maxDepth(BinaryTreeNode root) {
       if(root==null)
    	   return 0;
       return getMaxDepth(root);
    }
	
	/**
	 * Time COmplexity-O(logn)-->height of the binary tree.
	 * Space Coomplexity-O(n)
	 *
	 */
	public static int getMaxDepth(BinaryTreeNode rootNode) {
		
		if(rootNode==null)
			return 0;
		else 
			return Math.max(1+getMaxDepth(rootNode.getLeftNode()), 1+getMaxDepth(rootNode.getRightNode()));
	}

}
