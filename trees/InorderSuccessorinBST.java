package com.trees.practice;

/**
 * 285.Inorder Successor in BST
 * 
 * Given a binary search tree and a node in it, 
 * find the in-order successor of that node in the BST.
 *
 */
public class InorderSuccessorinBST {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(10);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(6);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(14);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(4);
		
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(8);
		
		leftNode1.setLeftNode(leftNode11);
		leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(12);
		
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(15);
		
		rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		System.out.println(inorderSuccessor(root1, leftNode1).getData());
	}
	
	/**
	 * 
	 *  Algorithm to find inorder successor
     * 
	 *	1. Start with root. Initialize successor as NULL.
	 *	2. If given node less than root, then search on left side and update successor. 
	 *	3. If node is greater than root, then search in right part, don't update successor.
	 *	4. When reached at node :
   	 *	4.1 If node has right subtree, return minimum node on right subtree. 
   	 *	4.2 Else return successor.
   	 *
   	 *  Candidates for inorder successor of a node are as follows:
     *
     *	If there is right subtree of node, output is left most child in the right subtree.
     *	If there is no right subtree, output is the node where last left turn was taken to reach given node.
     *
	 *	First and second conditions are mutually exclusive that means, if first is true then second does not hold and vice-a-versa.
	 *	What if node given is right most node in tree? In that case both conditions will return NULL as there is no right subtree and there was no left turn taken to reach the node.
	 * 
	 * 
	 * Time Complexity-O(h)-->height of the tree
	 * Space Complexity-O(1)
	 * 
	 * 
	 */
	public static BinaryTreeNode inorderSuccessor(BinaryTreeNode root, BinaryTreeNode p) {
	
		if(root==null)return null;
		
		BinaryTreeNode curr=root;
		BinaryTreeNode successor = null;
		
		//get to the current element
		while(p.getData()!=curr.getData()) {
			
			if(curr.getData()>p.getData()) {
				/* If node value is greater than the node 
		        which are looking for, then go to left sub tree
		        Also when we move left, update the successor 
		        pointer to keep track of 1st left turn */
				//we need to store the successor value since if the required node does not have any 
				//right child then the successor would be the node from which the last left turn has been 
				//taken to reach the present node i.e the successor.
				successor=curr;

				curr=curr.getLeftNode();
			}else 
			{
				//in case of right most node in the BST it will not have any successor so it will return null.
				/* Else take right turn and no need 
		        to update successor pointer */
				curr=curr.getRightNode();
			}
		}
		/*Once we reached at the node for which 
	      inorder successor is to be found,
	      check if it has right sub tree, 
	      if yes then find the minimum in that right sub tree 
	      and return right node 
	      Else last left turn taken node is already stored 
	      in successor pointer and will be returned*/
		if(curr!=null&&curr.getRightNode()!=null) {
			return findMinimuminBST(curr.getRightNode());
		}
		
		else 
			return successor;
		
	}
	
	public static BinaryTreeNode findMinimuminBST(BinaryTreeNode root) {
		if(root!=null) {
			while(root.getLeftNode()!=null) {
				root=root.getLeftNode();
			}
		}
		return root;
	}

}
