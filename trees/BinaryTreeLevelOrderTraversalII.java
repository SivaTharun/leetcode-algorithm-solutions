package com.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * @author SivaTharun
 *
 */
public class BinaryTreeLevelOrderTraversalII {

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
		
		System.out.println(levelOrderBottom(root1));

	}
	
	/**
	 *  Time Complexity-O(n)
	 *  Space Complexity-O(2^(n-1))-->leaf nodes
	 * @param root
	 * @return
	 */
	 public static List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {
	
		 List<List<Integer>> levelList =  new ArrayList<>();
		 Queue<BinaryTreeNode> queue = new LinkedList<>();
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 List<Integer> tempList = new ArrayList<>();
			 for(int i=0;i<queue.size();i++) {
				 BinaryTreeNode curr=queue.poll();
				 tempList.add(curr.getData());
				 if(curr.getLeftNode()!=null) {
					 queue.add(curr.getLeftNode());
				 }
				 if(curr.getRightNode()!=null) {
					 queue.add(curr.getRightNode());
				 }
			 }
			 levelList.add(tempList);
		 }
		 return levelList;
		 
	}

}
