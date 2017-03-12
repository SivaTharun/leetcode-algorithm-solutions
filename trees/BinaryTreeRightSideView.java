package com.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  199. Binary Tree Right Side View 
 *  Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
 * @author SivaTharun
 *
 */
public class BinaryTreeRightSideView {
	
	static int MAX_LEVEL=-1;
	static List<Integer> rightsideViewList=new ArrayList<Integer>();
	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(3);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(5);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(4);
		
		BinaryTreeNode leftNode111=new BinaryTreeNode();
		leftNode111.setData(7);
		leftNode11.setLeftNode(leftNode111);
		leftNode1.setRightNode(leftNode11);
		rightNode1.setRightNode(rightNode11);
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		System.out.println(rightSideViewBFS(root1));
	}
	
	public static List<Integer> rightSideView(BinaryTreeNode root) {
     if(root==null)return rightsideViewList;
     rightSideViewHelper(root, 1);
	 return rightsideViewList;
    }
	
	/**
	 * DFS based solution based on the level of current node
	 *  It is that once we see a node from right side, we can not see any node which are on the same level behind this node. This current node obstructs all other nodes.
     *
	 *	Idea here is very simple, all nodes which are at levels which are less than already visited level, will not be visible as they will be obstructed by one or more nodes on right hand side on already visited node. Since we need to visit the right most node first, take care that we need to start from right child here.
     *
	 *	If the current node is at level which is greater than maximum level we have visited till now, that node will be visible
	 * 
	 * Time Complexity-O(n)
	 * Space COmplexiy-O(h)-->height of the tree
	 * 
	 */
	public static void rightSideViewHelper(BinaryTreeNode root,int currentLevel) {
		//base condition for leaf node and termination of helper method.
		if(root==null)return;
		
		if(currentLevel>MAX_LEVEL) {
			MAX_LEVEL=currentLevel;
			rightsideViewList.add(root.getData());
		}
		//first get the max level value for the right most node
		rightSideViewHelper(root.getRightNode(), currentLevel+1);
		//compare that max level with current level of left nodes if it is more then add that element to list,since 
		//will be visible form right side
		rightSideViewHelper(root.getLeftNode(), currentLevel+1);
	}
	
	/**
	 * 
	 * Time Complexity-O(h)
	 * Space Complexity-O(2^(h)),where h is the height of the tree
	 * 
	 * 	 */
	public static List<Integer> rightSideViewBFS(BinaryTreeNode root) {
		List<Integer> resultList=new ArrayList<>();
		if(root==null)return resultList;
		Queue<BinaryTreeNode> queue=new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				BinaryTreeNode current = queue.poll();
				//add the first element at that level since it will only be visible from right side irrespective if it is a right or left node 
				if(i==0) {
					if(current!=null) {
					resultList.add(current.getData());
					}
				}
				//add the right most element first since the view is from right side
				if(current.getRightNode()!=null)
					queue.add(current.getRightNode());
				if(current.getLeftNode()!=null)
					queue.add(current.getLeftNode());
			}
		}
		return resultList;
	}
}
