package com.trees.practice;

/**
 * 437. Path Sum III
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000. 

 * @author SivaTharun
 *
 */
public class PathSumIII {

	static int NUMBER_OF_PATHS=0;
	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(10);
		
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(5);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(-3);
		
		BinaryTreeNode leftNode11=new BinaryTreeNode();
		leftNode11.setData(3);
		BinaryTreeNode rightNode11=new BinaryTreeNode();
		rightNode11.setData(2);
		BinaryTreeNode leftNode211=new BinaryTreeNode();
		leftNode211.setData(1);
		rightNode11.setRightNode(leftNode211);
		leftNode1.setLeftNode(leftNode11);
		leftNode1.setRightNode(rightNode11);
		
		BinaryTreeNode leftNode21=new BinaryTreeNode();
		leftNode21.setData(15);
		
		BinaryTreeNode rightNode21=new BinaryTreeNode();
		rightNode21.setData(11);
		//rightNode1.setLeftNode(leftNode21);
		rightNode1.setRightNode(rightNode21);
		
		
		root1.setLeftNode(leftNode1);
		root1.setRightNode(rightNode1);
		
		System.out.println(pathSum(root1, 8));
	}

	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static int pathSum(BinaryTreeNode root,int sum) {
		
		if(root==null)return 0;
		pathSumHelper(root.getLeftNode(), Math.abs(sum));
		pathSumHelper(root.getRightNode(), Math.abs(sum));
		return NUMBER_OF_PATHS;
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(h)
	 * DFS helper solution
	 */
	public static void pathSumHelper(BinaryTreeNode root,int reqsum) {
		//base condition to skip for leaf nodes.
		if(root!=null) {
			//if added up to 0 then increase the count and this will skip for rest of the nodes,including the leat nodes
			if(reqsum-root.getData()==0){NUMBER_OF_PATHS++;}
			else {
				pathSumHelper(root.getLeftNode(), Math.abs(reqsum-root.getData()));
				pathSumHelper(root.getRightNode(), Math.abs(reqsum-root.getData()));
			}
		}
	}
}
