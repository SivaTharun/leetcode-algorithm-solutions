package com.trees.practice;

/**
 *  129. Sum Root to Leaf Numbers 
 *  Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

	An example is the root-to-leaf path 1->2->3 which represents the number 123.

	Find the total sum of all root-to-leaf numbers.

	For example,

    1
   / \
  2   3

	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25. 
 * @author SivaTharun
 *
 */
public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(1);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(2);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(3);
		
/*		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(5);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(3);
		
		BinaryTreeNode leftNode111=new BinaryTreeNode();
		leftNode111.setData(7);
		leftNode11.setLeftNode(leftNode111);
		leftNode1.setRightNode(leftNode11);
		rightNode1.setRightNode(rightNode11);*/
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
	
		System.out.println(sumNumbers(root1));
	}

	 public static int sumNumbers(BinaryTreeNode root) {
		 if(root==null)return 0;
		 return dfsPathSum(root, 0, 0);
	 }
	 
	 /**
	  * Time Complexity-O(h)
	  * Space Complexity-O(h)
	  * DFS Based solution
	  */
	 public static int dfsPathSum(BinaryTreeNode root,int sum,int res) {
		 //base condition for leaf nodes in a skewed tree then return result
		 if(root==null)return res;
		 //leaf node
		 sum=sum*10+root.getData();
		 if(root.getLeftNode()==null&&root.getRightNode()==null) {
			 res=res+sum;
			 return res;
		 }
		 
		 //return the sum of both the sub trees.
		  res= dfsPathSum(root.getLeftNode(), sum, res)+dfsPathSum(root.getRightNode(), sum, res);
		 //update the value of res before returning
		 return res;
	 }
	 
}
