package com.trees.practice;

/**
 *
 *
 *
 *
 */
public class LowestCommonAncestorofaBinaryTree {

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
	
		System.out.println(lowestCommonAncestorUtil(root1,leftNode1,rightNode11).getData());
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        
		if(root==null)return null;
		if(root.getData()==p.getData()||root.getData()==q.getData()) {
			return root;
		}
		
		BinaryTreeNode leftSubtree=lowestCommonAncestor(root.getLeftNode(), p, q);
		BinaryTreeNode rightSubTree=lowestCommonAncestor(root.getRightNode(), p, q);
		//both the nodes are in different subtrees
		if(leftSubtree!=null&&rightSubTree!=null)return root;
		//if both the subtrees are in the same subtree i.e either left or right subtree
		return (leftSubtree!=null)?leftSubtree:rightSubTree;
    }
	
	/**
	 * 
	 *
	 * 
	 */
	public static BinaryTreeNode lowestCommonAncestorUtil(BinaryTreeNode root,BinaryTreeNode p, BinaryTreeNode q) {
			
		BinaryTreeNode lca=lowestCommonAncestor(root, p, q);
		return lca;
	}
	
}
