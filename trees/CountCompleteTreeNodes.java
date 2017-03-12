package com.trees.practice;

/**
 * 222. Count Complete Tree Nodes
 * 
 *  Given a complete binary tree, count the number of nodes.
 *  
 *	Definition of a complete binary tree from Wikipedia:
 *	In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *  
 * @author SivaTharun
 *
 */
public class CountCompleteTreeNodes {

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
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		System.out.println(countNodes(root1));
	}
	
	/**
	 * Time Complexity-O((logn)^2)-->from master's theorem.
	 * Space Complexity-O(logn)-->height of the tree
	 * 
	 * 
	 */
    public static int countNodes(BinaryTreeNode root) {
    	if(root==null)return 0;
    	int lHeight=1+getHeightOfCompleteLeftTree(root.getLeftNode());
    	int rHeight=1+getHeightOfCompleteRightTree(root.getRightNode());
    	
    	//if it is a full complete tree
    	if(lHeight==rHeight) {
    		return 1<<(lHeight);
    	}
    	else return 1+countNodes(root.getLeftNode())+countNodes(root.getRightNode());
    	
    	
    }
    
    /**
     * For a complete left binary tree the no of elements can be 2^h for height h if 
     * all the levels in left sub tree leaf are completely filled.
     * since in a complete tree,the left subtree is filled first.
     * 
     */
    public static int getHeightOfCompleteLeftTree(BinaryTreeNode root) {
    	if(root==null)return 0;
    	return 1+getHeightOfCompleteLeftTree(root.getLeftNode());
    }
    
    /**
     * For a complete right binary tree the no of elements can be 2^h for height h 
     * if all the levels in right level iff right subtree is completely filled 
     * 
     */
    public static int getHeightOfCompleteRightTree(BinaryTreeNode root) {
    	if(root==null)return 0;
    	return 1+getHeightOfCompleteRightTree(root.getRightNode());
    }
    
}
