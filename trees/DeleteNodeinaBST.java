package com.trees.practice;

/**
 *  450. Delete Node in a BST 
 *  Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 * @author SivaTharun
 *
 */
public class DeleteNodeinaBST {

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
		
		
		BinaryTreeNode root=deleteNode(root1, 4);
		System.out.println(root.getData());
	}
	
	/**
	 * Time COmplexity-O(h)
	 * Space COmplexity-O(h)-->for the recursion stack
	 * 
	 */
	public static BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
		//base case for a leaf node 
		if(root==null)return null;
		//if it is in the left sub tree move to the left sub tree and correspondingly
		//update the root's left node with the so going to be deleted node
		if(key>root.getData()) {
			root.setRightNode(deleteNode(root.getRightNode(), key));
		}else if(key<root.getData()) {
			root.setLeftNode(deleteNode(root.getLeftNode(), key));
		}
		if(root.getLeftNode()==null)
			//this case will satisfy the condition in which the node does not have any subtrees,it directly delets the node by setting it to null
			return root.getRightNode();
		else if(root.getRightNode()==null)
			return root.getLeftNode();
		//in case the node has both left and right subtrees
		int minValue=getMinValueInorderSuccesor(root.getRightNode());
		root.setData(minValue);
		//delete the inorder succesor
		root.setRightNode(deleteNode(root.getRightNode(), minValue));
		return root;
	}
	
	/**
	 * this value gives the inorder succesor for the node
	 * @param root
	 * @return
	 */
	public static int getMinValueInorderSuccesor(BinaryTreeNode root) {
		int minValue=root.getData();
		while(root.getLeftNode()!=null) {
			root=root.getLeftNode();
			minValue=root.getData();
		}
		return minValue;
	}
}
