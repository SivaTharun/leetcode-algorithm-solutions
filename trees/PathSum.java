package com.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 112. Path Sum
 * Given a binary tree and a sum, determine 
 * if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
 * @author SivaTharun
 *
 */
public class PathSum {

	public static void main(String[] args) {

		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(5);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(4);
		BinaryTreeNode leftNode11 = new BinaryTreeNode();
		leftNode11.setData(11);
		BinaryTreeNode leftNode111 = new BinaryTreeNode();
		leftNode111.setData(2);
		leftNode11.setLeftNode(leftNode111);
		leftNode1.setLeftNode(leftNode11);
		
		BinaryTreeNode rightNode11 = new BinaryTreeNode();
		rightNode11.setData(3);
		leftNode1.setRightNode(rightNode11);
		root1.setLeftNode(leftNode1);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(2);
		BinaryTreeNode leftNode12 = new BinaryTreeNode();
		leftNode12.setData(3);
		rightNode1.setLeftNode(leftNode12);
		
		BinaryTreeNode rightNode12 = new BinaryTreeNode();
		rightNode12.setData(3);
		rightNode1.setRightNode(rightNode12);
		root1.setRightNode(rightNode1);
	
		int sum =22;
		System.out.println(hasPasthSumRecursiveMethod(root1, sum));
	}
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public static boolean hasPathSum(BinaryTreeNode root, int sum) {
        
		return pathSumBoolean(root, sum);
    }
	
	/**
	 * Time Complexity-O(n*n)-->worst in case iterating through the leaf nodes in the queue and checking for the sum
	 * Space Complexity-O(n)-->O(2^(logn))
	 * 
	 */
	public static boolean pathSumBoolean(BinaryTreeNode root,int sum) {
		
		Queue<BinaryTreeNode> BFSQueue = new LinkedList<>();
		if(root==null) {
			return false;
		}	
		BFSQueue.add(root);
		List<Integer> sumList = new ArrayList<>();
		sumList.add(-1);
		BinaryTreeNode current=BFSQueue.peek();
		while(!BFSQueue.isEmpty()) {
			//root node
		 if(sumList.contains(-1))
		 {
		 sumList.clear();	 
		 sumList.add(current.getData());
		 if(current.getLeftNode()!=null)
			 BFSQueue.add(current.getLeftNode());
		 if(current.getRightNode()!=null) 
			 BFSQueue.add(current.getRightNode());
		 BFSQueue.poll();
		 continue;
		 }
		 int size=BFSQueue.size();
		 List<Integer> tempsumList=new ArrayList<>();
		 for(int i=0;i<size;i++) {
			 current=BFSQueue.poll();
			 
			 for(int j=0;j<sumList.size();j++) {
				 //here we check for all possible combinations of sum from root node to the leaf node
				 //total combinations-O(N*N-1)
				 if(current.getData()+sumList.get(j)==sum)
				 {
					 return true;
				 }
				 else {
					 //if not matching even then add the result to the sum list to use it for next level calculations.
					 tempsumList.add(current.getData()+sumList.get(j));
				 }
			 }
			 if(current.getLeftNode()!=null)
				 BFSQueue.add(current.getLeftNode());
			 if(current.getRightNode()!=null)
				 BFSQueue.add(current.getRightNode());
		 }
		 sumList=tempsumList;
		}	
		return false;
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-1/2*O(n)
	 * Maintain two queues,one for nodes and other for the sum obtained
	 * to keep track of the sum obtained for each node.
	 * 
	 */
	public static boolean hasPathSumBFSUsingTwoQueues(BinaryTreeNode root,int sum) {
		Queue<BinaryTreeNode> nodeQueue=new LinkedList<>();
		Queue<Integer> integerQueue = new LinkedList<>();
		if(root==null)
			return false;
		nodeQueue.add(root);
		integerQueue.add(root.getData());
		while(!nodeQueue.isEmpty()) {
			BinaryTreeNode current = nodeQueue.poll();
			int sumValue=integerQueue.poll();
			if(current.getLeftNode()==null&&current.getRightNode()==null&sumValue==sum)
				return true;
			if(current.getLeftNode()!=null) {
				nodeQueue.add(current.getLeftNode());
				integerQueue.add(current.getLeftNode().getData()+sumValue);
			}
			if(current.getRightNode()!=null) {
				nodeQueue.add(current.getRightNode());
				integerQueue.add(current.getRightNode().getData()+sumValue);
			}	
		}
		return false;
	}
	
	/**
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 * 
	 */
	public static boolean hasPasthSumRecursiveMethod(BinaryTreeNode root,int sum) {
		if(root==null)
			return false;
		sum = sum-root.getData();
		if(sum==0)
			return true;
		boolean leftFlag=hasPasthSumRecursiveMethod(root.getLeftNode(), sum);
		boolean rightFlag=hasPasthSumRecursiveMethod(root.getRightNode(), sum);
		return leftFlag||rightFlag;
	}
	/**
	 * 
	 * @return
	 *//*
	public static boolean hasPathSumRecursive(BinaryTreeNode root,int sum) {
		if(root==null)
		return false;
		return hasPathSumRecursiveDriver(root, sum,0);
	}*/
	
	//need to work on this Solution
	/*public static boolean hasPathSumRecursiveDriver(BinaryTreeNode root,int sum,int presentSum) {
		
		if(root.getLeftNode()!=null && root.getRightNode()!=null) {
			if(presentSum+root.getData()==sum)
			return true;
			else {
				presentSum=presentSum+root.getData();
				boolean leftNodeflag=hasPathSumRecursiveDriver(root.getLeftNode(),sum, presentSum);
				boolean rightNodeflag=hasPathSumRecursiveDriver(root.getRightNode(),sum, presentSum);
				return leftNodeflag||rightNodeflag;	
			}
		}
		
		if(root.getLeftNode()==null) {
			if(root.getData()+presentSum==sum)
				return true;
			else {
				presentSum=root.getData()+presentSum;
			return hasPathSumRecursiveDriver(root.getRightNode(),sum, presentSum);
			}
		}
		if(root.getRightNode()==null) {
			if(root.getData()+presentSum==sum)
				return true;
			else {
				presentSum=root.getData()+presentSum;
				return hasPathSumRecursiveDriver(root.getLeftNode(),sum, presentSum);
			}
		}
		
		return false;
	}*/
}
