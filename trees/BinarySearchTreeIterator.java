package com.trees.practice;

import java.util.Stack;

/**
 *  173. Binary Search Tree Iterator 
 * 	Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 
 We all know that, once you get to a TreeNode, in order to get the smallest, you need to go all the way down its left branch. So our first step is to point to pointer to the left most TreeNode. The problem is how to do back trace. Since the TreeNode doesn't have father pointer, we cannot get a TreeNode's father node in O(1) without store it beforehand. Back to the first step, when we are traversal to the left most TreeNode, we store each TreeNode we met ( They are all father nodes for back trace).

After that, I try an example, for next(), I directly return where the pointer pointing at, which should be the left most TreeNode I previously found. What to do next? After returning the smallest TreeNode, I need to point the pointer to the next smallest TreeNode. When the current TreeNode has a right branch (It cannot have left branch, remember we traversal to the left most), we need to jump to its right child first and then traversal to its right child's left most TreeNode. When the current TreeNode doesn't have a right branch, it means there cannot be a node with value smaller than itself father node, point the pointer at its father node.

The overall thinking leads to the structure Stack, which fits my requirement so well.

 * @author SivaTharun
 *
 */
public class BinarySearchTreeIterator {

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
		
		BinarySearchTreeIterator i = new BinarySearchTreeIterator(root1);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	static Stack<BinaryTreeNode> stack= new Stack<>();
	public BinarySearchTreeIterator(BinaryTreeNode root) {
		pushOnTOStack(root);
    }
	
	/**
	 * Time Complexity-O(1)
	 */
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Time Complexity-O(h) 
     */
    /** @return the next smallest number */
    public int next() {
        BinaryTreeNode node=stack.pop();
        if(node.getRightNode()!=null) {
        	node=node.getRightNode();
        	pushOnTOStack(node);
        }
    	return node.getData();
    }
    
    private void pushOnTOStack(BinaryTreeNode curr) {
    	
    	while(curr!=null) {
    		stack.push(curr);
    		curr=curr.getLeftNode();
    	}
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
