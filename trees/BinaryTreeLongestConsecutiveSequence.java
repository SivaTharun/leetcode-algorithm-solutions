package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 *	The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 *	The longest consecutive path need to be from parent to child (cannot be the reverse). 
 *
 */
public class BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {

		BinaryTreeNode root=new BinaryTreeNode();
		root.setData(5);
		BinaryTreeNode left1=new BinaryTreeNode();
		left1.setData(8);
		BinaryTreeNode left11=new BinaryTreeNode();
		left11.setData(9);
		BinaryTreeNode left111=new BinaryTreeNode();
		left111.setData(6);
		BinaryTreeNode right1=new BinaryTreeNode();
		right1.setData(11);
		BinaryTreeNode right11=new BinaryTreeNode();
		right11.setData(10);
		BinaryTreeNode left21=new BinaryTreeNode();
		left21.setData(15);

		left11.setLeftNode(left111);
		left1.setLeftNode(left11);
		root.setLeftNode(left1);
		right11.setLeftNode(left21);
		right1.setRightNode(right11);
		root.setRightNode(right1);
		System.out.println(longestConsecutive(root));
		
	}
	
	
	/**
	 * Time Complexity-O(n) 
	 * Space Complexity-O(n)
	 */
	public static int longestConsecutive(BinaryTreeNode root) {

		return root==null?0:Math.max(consecutiveHelper(root.getLeftNode(), 1, root.getData()), consecutiveHelper(root.getRightNode(), 1, root.getData()));
	}

	public static int consecutiveHelper(BinaryTreeNode child,int count,int parentValue) {
		if(child==null)return 0;
		count=Math.abs(parentValue-child.getData())==1?count+1:1;
		int left=consecutiveHelper(child.getLeftNode(), count, child.getData());
		int right=consecutiveHelper(child.getRightNode(), count, child.getData());
		//compare the current count at root and left and right and return the max value
		//as the count at child level will be the updated count value
		return Math.max(Math.max(left, right),count);
		
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 * 
	 */
	public static int BFSlongestConsecutive(BinaryTreeNode root) {
		//global variable to track the consecutive count
		int ans=0;
		Queue<countHelperBFS> queue=new LinkedList<>();
		if(root==null)return ans;
		queue.add(new countHelperBFS(root, 1));
		while(!queue.isEmpty()) {
			countHelperBFS current=queue.remove();
			//update the global max variable count
			ans=Math.max(ans, current.currentCount);
			int l=current.currentCount;
			BinaryTreeNode currentNode=current.node;
			int temp=currentNode.getData()+1;
			if(currentNode.getLeftNode()!=null) {
				
				l=temp==currentNode.getLeftNode().getData()?l+1:1;
				queue.add(new countHelperBFS(currentNode.getLeftNode(), l));
			}
			if(currentNode.getRightNode()!=null) {
				l=temp==currentNode.getRightNode().getData()?l+1:1;
				queue.add(new countHelperBFS(currentNode.getRightNode(), l));
			}
			
		}
		return ans;
	}
	
	//class to hold the tree node value and its longest consecutive count
	public static class countHelperBFS {
		BinaryTreeNode node;
		int currentCount;
		public countHelperBFS(BinaryTreeNode node, int currentCount) {
			this.node = node;
			this.currentCount = currentCount;
		}
	}
	
}