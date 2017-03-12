package com.trees.practice;

import java.util.Stack;

/**
 * 100. Same Tree 
 *  Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 * @author SivaTharun
 *
 */
public class SameTree {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		BinaryTreeNode root2= new BinaryTreeNode();
		root1.setData(1);
		root2.setData(1);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		root1.setLeftNode(leftNode1);
		BinaryTreeNode leftNode2=new BinaryTreeNode();
		leftNode2.setData(2);
		root2.setLeftNode(leftNode2);
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(3);
		root1.setRightNode(rightNode1);
		BinaryTreeNode rightNode2=new BinaryTreeNode();
		rightNode2.setData(3);
		root2.setRightNode(rightNode2);
		
		System.out.println(isSameTreeIteartive(root1,root2));
	}
	
	/**
	 * Recursive solution
	 * @param p
	 * @param q
	 * @return
	 * 
	 * Time Comlexity-O(2^n)-->since two paths for the binary tree to check-->left node and the right node.
	 */
   public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        
	   if(p==null && q==null)
		   return true;
	   else if(p==null && q!=null) {
		   return false;
	   } else if(p!=null && q==null) {
		   return false;
	   }
	   if(p.getData()!=q.getData())
		   return false;
	   return isSameTree(p.getLeftNode(), q.getLeftNode()) && isSameTree(p.getRightNode(), q.getRightNode());
    }
   
   /**
    *  Time Complexity-O(logn)-->no of levels of the complete binary tree.
    *  Space Complexity-O(n)
    * @param p
    * @param q
    * @return
    */
   public static boolean isSameTreeIteartive(BinaryTreeNode p, BinaryTreeNode q) {
	  Stack<BinaryTreeNode> stack1=new Stack<>();
	  Stack<BinaryTreeNode> stack2=new Stack<>();
	  stack1.push(p);
	  stack2.push(q);
	  
	  while(!stack1.isEmpty() && !stack2.isEmpty()) {
		  BinaryTreeNode temp1=stack1.pop();
		  BinaryTreeNode temp2=stack2.pop();
		  if(temp1.getData()!=temp2.getData())
			  return false;
		  if(temp1.getLeftNode()!=null && temp2.getLeftNode()!=null) {
			  stack1.push(temp1.getLeftNode());
			  stack2.push(temp2.getLeftNode());
		  }
		  else if(temp1.getLeftNode()==null && temp2.getLeftNode()==null) {
			  
		  }else {
			  return false;
		  }
		  if(temp1.getRightNode()!=null&&temp2.getRightNode()!=null) {
			  stack1.push(temp1.getRightNode());
			  stack2.push(temp2.getRightNode());
		  } else if(temp1.getRightNode()==null && temp2.getRightNode()==null) {
			  
		  } else  {
			  return false;
		  }
		  
	  }
	  if(!stack1.isEmpty()|| !stack2.isEmpty())return false;
	   return true;
   }

}
