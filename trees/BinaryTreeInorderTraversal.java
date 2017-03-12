package com.trees.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal 
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2]. 
 * @author SivaTharun
 *
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(3);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(2);
		rightNode1.setLeftNode(leftNode11);
		//root1.setLeftNode(leftNode11);
		root1.setRightNode(rightNode1);
		System.out.println(inorderTraversal(root1));
	}
	
	/**
	 * Time Complexity-O(K)-->the k nodes in the tree
	 * space Complexity-O(n)
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(BinaryTreeNode root) {
		List<Integer> inorderTraversalList=new ArrayList<>();
		if(root==null) {
			return inorderTraversalList;
		}
		Stack<BinaryTreeNode> inorderStack = new Stack<>();
		BinaryTreeNode node =root;
		while(node!=null) {
			inorderStack.push(node);
			node=node.getLeftNode();
		}
		//add the left most element as the first element to stack
		while(!inorderStack.isEmpty()) {
			node=inorderStack.pop();
			//print the element
			inorderTraversalList.add(node.getData());
			//get the right element of the current element
			//and add its left most element
			//add the right element of the left most node iff it is not null else continue with the existing flow
			if(node.getRightNode()!=null) {
			node =node.getRightNode();
			//move the left most node of right node to the top stack 
			while(node!=null) {
				inorderStack.push(node);
				node=node.getLeftNode();

			}
			}
			
		}
		return inorderTraversalList;
	}

}
