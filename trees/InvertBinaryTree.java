package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree 
 * 
 * @author SivaTharun
 *
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(3);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(4);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(5);
		leftNode1.setLeftNode(leftNode11);
		leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(6);
		
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(7);
		rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		
		invertBinaryTreeIterative(root1);
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root1);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			System.out.println(temp.getData());
			if(temp.getLeftNode()!=null && temp.getRightNode()!=null) {
			queue.add(temp.getLeftNode());
			queue.add(temp.getRightNode());
			}
		}
		
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)-->storing the no of nodes in recursion stack till a leaf node is called-->height of the tree. 
	 * 
	 */
	public static void invertBinaryTree(BinaryTreeNode root) {
		if(root==null)return;
		BinaryTreeNode leftNode = null;
		BinaryTreeNode rightNode = null;
		if(root.getLeftNode()!=null)
		 leftNode = root.getLeftNode();
		if(root.getRightNode()!=null)
		 rightNode = root.getRightNode();
		if(leftNode!=null && rightNode!=null) {
			BinaryTreeNode temp=leftNode;
		root.setLeftNode(rightNode);
		root.setRightNode(temp);
		}
		invertBinaryTree(root.getLeftNode());
		invertBinaryTree(root.getRightNode());
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Comlexxity-1/2*O(n)-->total no of leaf nodes.
	 */
	public static void invertBinaryTreeIterative(BinaryTreeNode root) {
		if(root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode current=queue.poll();
			BinaryTreeNode leftNode=current.getLeftNode();
			BinaryTreeNode rightNode = current.getRightNode();
			current.setRightNode(leftNode);
			current.setLeftNode(rightNode);
			if(current.getLeftNode()!=null)
			queue.add(current.getLeftNode());
			if(current.getRightNode()!=null)
			queue.add(current.getRightNode());
		}
	}
}
