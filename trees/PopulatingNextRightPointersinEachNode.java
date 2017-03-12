package com.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  116. Populating Next Right Pointers in Each Node 
 *  
 *   Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * 
 *
 */
class TreeLinkNode {

	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

/**
 * 
 * 
 *
 */
public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {

		TreeLinkNode root1=new TreeLinkNode(10);
		
		TreeLinkNode leftNode1=new TreeLinkNode(6);
		
		TreeLinkNode rightNode1=new TreeLinkNode(14);
		
		TreeLinkNode leftNode11=new TreeLinkNode(4);
		
		TreeLinkNode rightNode11=new TreeLinkNode(8);
		
		leftNode1.left=leftNode11;
		leftNode1.right=rightNode11;
		
		TreeLinkNode leftNode21=new TreeLinkNode(12);
		
		TreeLinkNode rightNode21=new TreeLinkNode(15);
		
		rightNode1.left=(leftNode21);
		rightNode1.right=(rightNode21);
		
		root1.left=(leftNode1);
		root1.right=(rightNode1);
		connectPreOrder(root1);
		
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)-->the no of nodes in the tree
	 */
	public static void connectBFS(TreeLinkNode root) {
		
		Queue<TreeLinkNode> queue=new LinkedList<>();
		Queue<Integer> levelQueue=new LinkedList<>();
		queue.add(root);
		levelQueue.add(1);
		while(!queue.isEmpty()) {
			
			TreeLinkNode curr=queue.poll();
			int level=levelQueue.poll();
			if(queue.isEmpty()) {
				curr.next=null;
			} else if(level<levelQueue.peek()) {
				curr.next=null;
			}else {
				curr.next=queue.peek();
			}
			
			if(curr.left!=null)
			{
				queue.add(curr.left);
				levelQueue.add(level+1);
			}
			if(curr.right!=null) {
				queue.add(curr.right);
				levelQueue.add(level+1);
			}
		}
		
		
    }
	
	/**
	 * 
	 * 
	 */
	public static void connectPreOrder(TreeLinkNode root) {
		
		// Set the nextRight for root
		root.next=null;
		// Set the next right for rest of the nodes (other than root)
		connectRecursion(root);
	}
	
	/**
	 * Applicable only for Complete trees.
	 * 
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 *      1
          /    \
        2        3
       / \      /  \
      4   5    6    7
     / \           / \  
    8   9        10   11
	 * Why doesn’t method 2 work for trees which are not Complete Binary Trees?
	 * Let us consider following tree as an example.
	 * In Method 2, we set the nextRight pointer in pre order fashion. 
	 * When we are at node 4, we set the nextRight of its children which are 8 and 9 (the nextRight of 4 is already set as node 5). 
	 * nextRight of 8 will simply be set as 9, but nextRight of 9 will be set as NULL which is incorrect. 
	 * We can’t set the correct nextRight, because when we set nextRight of 9, we only have nextRight of node 4 and ancestors of node 4, we don’t have nextRight of nodes in right subtree of root.
	 */
	static void connectRecursion(TreeLinkNode p) {
		
		//base case for leaf nodes
		if(p==null)return;
		//set the next node of p as the right node of p.
		if(p.left!=null) {
			p.left.next=p.right;
		}
		if(p.right!=null) {
			if(p.next!=null)
				//case for which p is not the last node in that level.
				p.right.next=p.next.left;
			else 
				//case for which the p.right is last node in that level.
				p.right.next=null;
		}
		// Set nextRight for other nodes in pre order fashion
		//first the left most node in the tree is called upon this method and then other right nodes are being called upon the method stack
		connectRecursion(p.left);
		connectRecursion(p.right);
	}
}
