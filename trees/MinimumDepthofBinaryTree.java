package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author SivaTharun
 *
 */
public class MinimumDepthofBinaryTree {

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
		
		System.out.println(minDepthIterativeUsingBFS(root1));
	
	}
	
	/**
	 * 
	 * 
	 */
	/*public static int minDepthIterative(BinaryTreeNode root) {
		
		if(root==null)return 0;
		Stack<BinaryTreeNode> treeStack = new Stack<>();
		treeStack.push(root);
		while
		
	}*/
	
	/**
	 * Time Complexity-O(n)
	 * Space  Complexity-O(n)
	 * 
	 * 
	 */
	public static int minDepth(BinaryTreeNode root) {
        	
		if(root==null)
			return 0;
		//return Math.min(1+minDepth(root.getLeftNode()), 1+minDepth(root.getRightNode()));
		int left=minDepth(root.getLeftNode());
		int right=minDepth(root.getRightNode());
		if(Math.min(left, right)>0){
			return 1+Math.min(left, right);
		}else
			//in case of a skewed tree,the minimum height will be the max depth(height) of either left/right skewed tree.
			return 1+Math.max(left, right);
    }

	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(2^(n/2))-->for tail nodes for a complete binary tree
	 * 
	 * 
	 */
	public static int minDepthIterativeUsingBFS(BinaryTreeNode root) {
		//initial height of the binary tree with root is one
		int minHeight=0;
		if(root==null)
			return minHeight;
		Queue<BinaryTreeNode> dfsQueue= new LinkedList<>();
		dfsQueue.add(root);
		while(!dfsQueue.isEmpty()) {
			//increase the minimum height for the tree 
			minHeight++;
			//get the queue size to iterate through all the nodes at particular level.
			int k=dfsQueue.size();
			for(int i=0;i<k;i++) {
				BinaryTreeNode current = dfsQueue.poll();
				if(current.getLeftNode()==null&&current.getRightNode()==null)
					//return the height only in case if the leaf node and not a skewed node.
					//in case of skewed node that node is added to the queue and the above process continues.
					return minHeight;
				if(current.getLeftNode()!=null)
					dfsQueue.add(current.getLeftNode());
				if(current.getRightNode()!=null)
					dfsQueue.add(current.getRightNode());
			}
		}
		//will never gets executed
		return -1;
	}
}
