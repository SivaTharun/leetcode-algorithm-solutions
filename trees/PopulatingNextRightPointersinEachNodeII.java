package com.trees.practice;

/**
 *  117. Populating Next Right Pointers in Each Node II 
 *  Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

 * @author SivaTharun
 *
 */

public class PopulatingNextRightPointersinEachNodeII {

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
		connect(root1);
		
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(1)
	 * 
	 * 
	 */
	public static void connect(TreeLinkNode root) {
     
		/**
		 * we have 4 pointers at 2 levels of the tree. 
		 * 	
		 */
		if(root == null) 
	        return;
		TreeLinkNode lastHead = root;//previous level's head 
	    TreeLinkNode lastCurrent = null;//previous level's pointer
	    TreeLinkNode currentHead = null;//current level's head 
	    TreeLinkNode current = null;//current level's pointer
	    
	    while(lastHead!=null) {
	    	//base condition for the while loop
	    	//assigning back last current as last head in each iteration
	    	lastCurrent=lastHead;
	    	
	    	while(lastCurrent!=null) {
	    		//left child is not null
	    		if(lastCurrent.left!=null) {
	    			//this will be the starting head for this level
	    			if(currentHead==null) {
	    				currentHead=lastCurrent.left;
	    				current=lastCurrent.left;
	    			}else{
	    				current.next=lastCurrent.left;
	    				
	    				current=current.next;
	    			}
	    			
	    		}
	    		//if right child is not null
	    		if(lastCurrent.right!=null) {
	    			if(currentHead==null) {
	    				currentHead=lastCurrent.right;
	    				current=lastCurrent.right;
	    			} else{
	    				//assigns the current nodes next value as previous level current's right 
	    				current.next=lastCurrent.right;
	    				//move the current to next current i.e the current node
	    				current=current.next;
	    			}
	    		}
	    		lastCurrent=lastCurrent.next;
	    	} 
	    	
	    	//update last head to current head for the next iteration
	    	lastHead=currentHead;
	    	//make this current head as null at start of each level.
	    	currentHead=null;
	    }
    }
}
