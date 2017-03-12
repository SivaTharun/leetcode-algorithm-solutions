package com.trees.practice;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 */
public class KthSmallestElementinaBST {

	public static void main(String[] args) {
		
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(50);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(30);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(70);
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(20);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(40);
		leftNode1.setLeftNode(leftNode11);
		leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(60);
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(80);
		rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		System.out.println(kthSmallest(root1, 3));
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)
	 * using the in order traversal to get the increasing order of the elements and keeping the 
	 * count of the elements that are popped.
	 */
	public static int kthSmallest(BinaryTreeNode root, int k) {
		if(root==null)
			return -1;
		Stack<BinaryTreeNode> stack=new Stack<>();
		BinaryTreeNode current=root;
		while(current!=null) {
			stack.push(current);
			current=current.getLeftNode();
		}
		while(!stack.isEmpty()) {
			BinaryTreeNode curr=stack.pop();
			k--;
			if(k==0) {
				return curr.getData();
			}
			if(curr.getRightNode()!=null) {
			curr=curr.getRightNode();
			while(curr!=null) {
				stack.push(curr);
				curr=curr.getLeftNode();
			}
		}
		}
		return -1;
    }
}
