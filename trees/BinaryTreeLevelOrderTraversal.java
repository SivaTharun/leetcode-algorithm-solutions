package com.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal 
 * 	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @author SivaTharun
 *
 */
public class BinaryTreeLevelOrderTraversal {

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
		
		System.out.println(levelOrder(root1));
		
	}

	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(logn)
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderUsingDFSRecursion(BinaryTreeNode root) {
		List<List<Integer>> resList=new ArrayList<>();
		if(root==null)
			return resList;
		levelOrderDriver(resList, 0, root);
		return resList;
	}
	
	public static void levelOrderDriver(List<List<Integer>> res,int level,BinaryTreeNode root) {
		if(root==null)
			return;
		if(level>=res.size())
			//add an new array iff level>result array size-->condition
			//add the arraylists in the final list as per the no of levels
			res.add(new ArrayList<Integer>());
		res.get(level).add(root.getData());
		levelOrderDriver(res, level+1, root.getLeftNode());
		levelOrderDriver(res, level+1, root.getRightNode());
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Comlexity-O(2^(logn-1))=1/2 O(n)
	 * 
	 * 
	 */
	 public static List<List<Integer>> levelOrder(BinaryTreeNode root) {
	 
		 if(root==null)
		 return null;
		 List<List<Integer>> levelOrderList = new ArrayList<>();
		 Queue<BinaryTreeNode> treeQueue = new LinkedList<>();
		 //List<Integer> first = new ArrayList<Integer>();
		 //first.add(root.getData());
		 //levelOrderList.add(first);
		 treeQueue.add(root);
		 while(!treeQueue.isEmpty()) {
			 /*BinaryTreeNode prev=treeQueue.poll();
			 List<Integer> temp= new ArrayList<>();
			 if(prev!=null) {
				 treeQueue.add(prev.getLeftNode());
				 treeQueue.add(prev.getRightNode());
				 if(prev.getLeftNode()!=null) {
					 temp.add(prev.getLeftNode().getData());
				 }
				 if(prev.getRightNode()!=null) {
					 temp.add(prev.getRightNode().getData());
				 }
				 if(temp.size()>0)
				 levelOrderList.add(temp);
			 }*/
			 List<Integer> levelList= new ArrayList<>();
			 int size=treeQueue.size();
			 
			 for(int i=0;i<size;i++) {
				 //itearate until all the queue elements that are added for a particular level are added to the list.
				 BinaryTreeNode current=treeQueue.poll();
				 levelList.add(current.getData());
				 if(current.getLeftNode()!=null)
					 treeQueue.add(current.getLeftNode());
				 if(current.getRightNode()!=null)
					 treeQueue.add(current.getRightNode());
			 }
			 levelOrderList.add(levelList); 
		 }
		 return levelOrderList;
	 }
}
