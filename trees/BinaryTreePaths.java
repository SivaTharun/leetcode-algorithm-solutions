package com.trees.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths 
 * Given a binary tree, return all root-to-leaf paths. 
 * 
 *  For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

   All root-to-leaf paths are: 
 * ["1->2->5", "1->3"]
 * 
 * @author SivaTharun
 *
 */
public class BinaryTreePaths {

	static List<String> res= new ArrayList<>();
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
		
		System.out.println(binaryTreePaths(root1));
		
	}
	
	public static List<String> binaryTreePaths(BinaryTreeNode root) {
		
		if(root==null)
			return res;
		//add the root value to the list
		dfsTreePath(root,String.valueOf(root.getData()));
		
		return res;
	}
	
	/**
	 * Time Complexity--2^n-->since there are two paths so the time complexity would be in this order
	 * space complexity-O(h)
	 * @param root
	 * @param list
	 */
	static void dfsTreePath(BinaryTreeNode root,String list) {
		//the parameter as current root node and the list that contains root node previously added 
		//
		//base case for the dfs
		//if a leaf node is encountered then add the path to the result list
		if(root.getLeftNode()==null&&root.getRightNode()==null) {
			res.add(list);
		return;
		}
		if(root.getLeftNode()!=null) {
			dfsTreePath(root.getLeftNode(), list+"-->"+String.valueOf(root.getLeftNode().getData()));
		}
		
		if(root.getRightNode()!=null) {
			
			dfsTreePath(root.getRightNode(), list+"-->"+String.valueOf(root.getRightNode().getData()));
		}
	}
}
