package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. 
 *  
 * @author SivaTharun
 *
 */
public class LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(6);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(8);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(0);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(4);
		leftNode1.setLeftNode(leftNode11);
		leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(7);
		
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(9);
		rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		
		System.out.println(lowestCommonAncestorIterative(root1,leftNode1,rightNode1).getData());
		
	}

	
	/**
	 * Recursive Solution
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)-->depends on height of the tree
	 * 
	 */
	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root,BinaryTreeNode p,BinaryTreeNode q) {
		
		//scenario in which the root is empty
		if(root==null||p==null||q==null)
			return null;
		
		if(root.getData()>p.getData()&&root.getData()>q.getData()) {
			//search in left sub tree
			return lowestCommonAncestor(root.getLeftNode(), p, q);
		}
		
		if(root.getData()<p.getData()&&root.getData()<q.getData()) {
			//search in right sub tree
			return lowestCommonAncestor(root.getRightNode(), p, q);
		}
		//case in which p and q are in different sub trees in the BST(the above two conditions fails),the the current root is the LCA for the both. 
		return root;
	}
	
	/**
	 * Iterative Solution
	 * Time Complexity-O(n)
	 * Space Complexity-O(n) 
	 * 
	 */
	public static BinaryTreeNode lowestCommonAncestorIterative(BinaryTreeNode root,BinaryTreeNode p,BinaryTreeNode q) {
		Queue<BinaryTreeNode> queue= new LinkedList<>();
		if(root==null)return null;
		queue.add(root);
		BinaryTreeNode resultNode=null;
		while(!queue.isEmpty()) {
			resultNode = queue.poll();
			//this approach is similar to bfs but here we search either in left or right subtree of the current node but not both
			if(resultNode.getData()>p.getData()&&resultNode.getData()>q.getData()) {
				//search in left sub tree
				queue.add(resultNode.getLeftNode());
			}
			if(resultNode.getData()<p.getData()&&resultNode.getData()<q.getData()) {
				//search in right sub tree
				queue.add(resultNode.getRightNode());
			}
		}
		//the node will be returned when both the nodes are in different subtrees
		return resultNode;
	}
}
