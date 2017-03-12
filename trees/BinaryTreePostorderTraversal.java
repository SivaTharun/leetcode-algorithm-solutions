package com.trees.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  145. Binary Tree Postorder Traversal 
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 *
	For example:
	Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

	return [3,2,1]. 
 * 
 * @author SivaTharun
 *
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(2);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(5);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(3);
		
		BinaryTreeNode leftNode111=new BinaryTreeNode();
		leftNode111.setData(7);
		leftNode11.setLeftNode(leftNode111);
		leftNode1.setRightNode(leftNode11);
		rightNode1.setRightNode(rightNode11);
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		
		System.out.println(postorderTraversalUsingOneStack(root1));
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 * Algorithm for postorder traversal using two stacks.
	 * 
	 * 1)push the root onto stack 1.
	 * 2)iterate the stack1 over a while loop till stack1 is empty.
	 * 3)pop the top of stack 1 and push it's left and right nodes to stack1
	 * 4)push the popped node from stack 1 to stack2
	 * 5)Iterate over the stack2 in a while loop to get the post order traversal.
	 * 
	 */
    public static List<Integer> postorderTraversal(BinaryTreeNode root) {
    	List<Integer> result=new ArrayList<>();
       if(root==null) return result;
       Stack<BinaryTreeNode> stack1=new Stack<>();
       Stack<BinaryTreeNode> stack2=new Stack<>();
       //push root on top of the stack1
       stack1.push(root);
       while(!stack1.isEmpty()) {
    	   BinaryTreeNode current=stack1.pop();
    	   //push the popped node from the 
    	   stack2.push(current);
    	   if(current.getLeftNode()!=null)
    		   stack1.push(current.getLeftNode());
    	   if(current.getRightNode()!=null)
    		   stack1.push(current.getRightNode());
       }
       
       while(!stack2.isEmpty()) {
    	   result.add(stack2.pop().getData());
       }
    	
    	return result;
    }
    
    /**
     * Algorithm:
     * 1)set the root as current.and create an empty stack. 
     * 2)iterate over a while loop with the condition current!=null (or) stack is not empty.
     * 3)get to the left most node of the tree while pushing these on to the stack and set that value to current.
     * 4)after reaching the left most node the current is null
     * 5)in the next iteration if current is null.then get the right node of peek of stack.
     * 6)i)if that is empty then that is a leaf node then pop top of stack and print it.
     * ii)iterate over the stack here and check if the temp is right child of peek of stack.
     * iii)if yes then,op that top of stack and print it.-->this means that the right child of the root is visted and it can be printed. 
     * 7)in step 5 if temp is not empty,that means it has a right node to visit and continue step2
     * 
     */
    public static List<Integer> postorderTraversalUsingOneStack(BinaryTreeNode root) {
    	List<Integer> result=new ArrayList<>();
    	if(root==null)return result;
    	Stack<BinaryTreeNode> stack=new Stack<>();
    	BinaryTreeNode current=root;
    	while(!stack.isEmpty()||current!=null) {
    		if(current!=null) {
    		stack.push(current);
    		//move the left most node in the tree on top of the stack
    		current=current.getLeftNode();
    		} else {
    			//condition for the left most node
    			//check if the left most node has a  right child
    			//if yes then we have to repeat the postorder process for that right child by setting current as temp
    			BinaryTreeNode temp=stack.peek().getRightNode();
    			//the  node does not have a right node
    			if(temp==null) {
    				//this is a leaf node
    				//in the 2nd iteration if the parent has a right sub tree then then a post order traversal is done for 
    				//the same
    				temp=stack.pop();
    				result.add(temp.getData());
    				//check if the leaf node is a part of right sub tree
    				//if yes then pop the pop of stack and print it it as the its child is already printed. 
    				while(!stack.isEmpty()&&temp==stack.peek().getRightNode()) {
    					temp=stack.pop();
    					result.add(temp.getData());
    				}
    			} else {
    				//visit the right node as it is not visited
    				current=temp;
    			}
    		}
    	}
		return result;
    }
    
}
