package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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
		
		System.out.println(isSymmetricBFSIterative(root1));
	}
	
	/**
	 * Time Complexity-O(n)-->since each node is visited only once
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(BinaryTreeNode root) {
		if(root!=null) {
		if(root.getLeftNode()!=null && root.getRightNode()!=null) {
			if(root.getLeftNode().getData()==root.getRightNode().getData()) {
				return isSymmetric(root.getLeftNode()) && isSymmetric(root.getRightNode());
			}
			else 
				return false;
		} else if(root.getLeftNode()==null && root.getRightNode()==null) {
			return true;
		} else if(root.getLeftNode()==null || root.getRightNode()==null) {
			return false;
		}
	}
	return false;
	}
	
	/**
	 * Time COmplexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetricBFSIterative(BinaryTreeNode root) {
		if(root==null)
			return true;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root.getLeftNode());
		queue.add(root.getRightNode());
		while(queue.size()>1) {
		 BinaryTreeNode left=queue.poll();
		 BinaryTreeNode right = queue.poll();
		 if(left==null&&right==null)
			 //skip the values when both left and right are null then continue with the next sequence
			 continue;
		 else if(left==null && right!=null) {
			 return false;
		 } else if(left!=null&&right==null) {
			 return false;
		 } else {
			 if(left.getData()!=right.getData())
					return false;
				}
		 queue.add(left.getLeftNode());
		 queue.add(left.getRightNode());
		 //adding in FIFO ds so have to maintaine symmetricity while adding elements
		 //since the left and right subtrees must be mirror images of each other
		 queue.add(right.getRightNode());
		 queue.add(right.getLeftNode());
		 }
		return true;
	}
}
