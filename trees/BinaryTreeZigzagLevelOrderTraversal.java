package com.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  103. Binary Tree Zigzag Level Order Traversal 
 *  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

	return its zigzag level order traversal as:

	[
  	[3],
  	[20,9],
  	[15,7]
	]

 * @author SivaTharun
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
		System.out.println(zigzagLevelOrder(root1));
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)-->depends on the number of leaf nodes 
	 * 
	 */
	public static List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
		
		List<List<Integer>> res= new ArrayList<>();
		if(root==null)return res;
		int level=height(root);
		//List<BinaryTreeNode> traversalList=new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int n=queue.size();
			List<Integer> tempList= new ArrayList<>();
			for(int i=0;i<n;i++) {
				BinaryTreeNode current=queue.poll();
				tempList.add(current.getData());
				if(level%2==0) {
				if(current.getLeftNode()!=null) {
					queue.add(current.getLeftNode());
				}
				if(current.getRightNode()!=null) {
					queue.add(current.getRightNode());
				}
				level--;
				}
				else {
					if(current.getRightNode()!=null) {
						queue.add(current.getRightNode());
					}
					if(current.getLeftNode()!=null) {
						queue.add(current.getLeftNode());
					}
					level--;
				}
			}
			res.add(tempList);
		}
		return res;
	}
	
	public static int height(BinaryTreeNode root) {
		if(root==null)
			return 0;
		int leftheight=height(root.getLeftNode())+1;
		int rightheight=height(root.getRightNode())+1;
		return Math.max(leftheight, rightheight);
	}
	
	
}
