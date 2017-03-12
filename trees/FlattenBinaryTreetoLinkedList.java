package com.trees.practice;

/**
 *  114. Flatten Binary Tree to Linked List 
 *   Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * @author SivaTharun
 *
 */
public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		BinaryTreeNode leftNode11 = new BinaryTreeNode();
		leftNode11.setData(3);
		BinaryTreeNode rightNode11 = new BinaryTreeNode();
		rightNode11.setData(4);
		leftNode1.setRightNode(rightNode11);
		leftNode1.setLeftNode(leftNode11);
		root1.setLeftNode(leftNode1);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(5);
		
		BinaryTreeNode rightNode12 = new BinaryTreeNode();
		rightNode12.setData(6);
		rightNode1.setRightNode(rightNode12);
		root1.setRightNode(rightNode1);
	
		flattenIterative(root1);
		System.out.println(root1);
	}
	
	/**
	 * Time Complexity-O(n)-->since each node of the tree as part of recursion
	 * Space Complexity-O(h)-->height of the tree--.the no of recursive calls
	 * 
	 *  To flatten a binary tree, according to the given example, is to recursively insert the left subtree to the right subtree and append the original right subtree to the end of the left subtree, i.e.

     root                        root
     /  \            ->            \
  left  right                      left
                                     \
                                    right

		Since we need to append the original right-tree to the end of the left subtree, we let the recursion function return the last node after flatten.
		
		 The basic idea is to use pre-order traversal. For a parent node, merge its left subtree to its right child, append the rest of the rest subtree to the right most child of the left substree. Then recursively move to its right child.
		 So the algorithm is as follows:

(1) store the right child (we call R)

(2) find the right-most node of left child

(3) set R as the right-most node's right child.

(4) set left child as the right child

(5) set the left child NULL

(6) set current node to current node's right child.

(7) iterate these steps until all node are flattened. 
	 */
	public static void flatten(BinaryTreeNode root) {
		
		if(root==null)
			return;
		    //take the values of left and right sub tree before changing them
			BinaryTreeNode left=root.getLeftNode();
			BinaryTreeNode right=root.getRightNode();
			root.setLeftNode(null);
			flatten(left);
			flatten(right);
			root.setRightNode(left);
			//the root value should not be changed as this is part of recursion
			BinaryTreeNode current=root;
			while(current.getRightNode()!=null) {
				current=current.getRightNode();
			}
			//in this scenario a bst is taken so the right subtree is behind the left subtree ,when the left sub tree is being set as 
			//right sub tree for the root
			current.setRightNode(right);
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(1)
	 * 
	 */
	public static void flattenIterative(BinaryTreeNode root) {
		if(root==null)
			return;
		BinaryTreeNode curr=root;
		while(curr!=null) {
			if(curr.getLeftNode()!=null) {
				if(curr.getRightNode()!=null){
					BinaryTreeNode next=curr.getLeftNode();
					while(next.getRightNode()!=null) {
						next=next.getRightNode();
					}
					//setting the right node as the rightmost node of the left subtree
					//on first iteration the right subtree is being set to the left subtree of the root
					next.setRightNode(curr.getRightNode());
				}
				//set the right subtree as the left subtree and put the left sub tree as null
				curr.setRightNode(curr.getLeftNode());
				//on first itration itself the left subtree of the tree is being set to null
				curr.setLeftNode(null);
			}
			//after the first iteration the root will have only right subtree,so iterate thorught he right sub tree.
			//the base condition to iterate through the tree set the next element 
			curr=curr.getRightNode();
		}
	}
}
