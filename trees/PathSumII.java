package com.trees.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class PathSumII {

	public static void main(String[] args) {
		
		BinaryTreeNode root1=new BinaryTreeNode();
		root1.setData(5);
		BinaryTreeNode leftNode1=new BinaryTreeNode();
		leftNode1.setData(4);
		BinaryTreeNode leftNode11 = new BinaryTreeNode();
		leftNode11.setData(11);
		BinaryTreeNode leftNode111 = new BinaryTreeNode();
		leftNode111.setData(2);
		BinaryTreeNode RightNode111 = new BinaryTreeNode();
		RightNode111.setData(7);
		leftNode11.setLeftNode(leftNode111);
		leftNode11.setRightNode(RightNode111);
		leftNode1.setLeftNode(leftNode11);
		
		BinaryTreeNode rightNode11 = new BinaryTreeNode();
		rightNode11.setData(3);
		leftNode1.setRightNode(rightNode11);
		root1.setLeftNode(leftNode1);
		
		BinaryTreeNode rightNode1=new BinaryTreeNode();
		rightNode1.setData(8);
		BinaryTreeNode leftNode12 = new BinaryTreeNode();
		leftNode12.setData(13);
		rightNode1.setLeftNode(leftNode12);
		
		BinaryTreeNode rightNode12 = new BinaryTreeNode();
		rightNode12.setData(4);
		BinaryTreeNode rightNode121 = new BinaryTreeNode();
		rightNode121.setData(5);
		BinaryTreeNode leftNode121 = new BinaryTreeNode();
		leftNode121.setData(1);
		rightNode12.setRightNode(rightNode121);
		rightNode12.setLeftNode(leftNode121);
		rightNode1.setRightNode(rightNode12);
		root1.setRightNode(rightNode1);
	
		int sum =22;
	
	 System.out.println(pathSum(root1, sum));	
	}
	
	static List<List<Integer>> result=new ArrayList<>();
	public static List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
		
		List<Integer> res= new ArrayList<>();
		if(root!=null) {
		
			pathSumHelper(root, sum, res);
		
		}
		return result;
    }
	
	/**
	 * DFS based solution(backtracking)
	 * Time Complexity-O(n)
	 * Space Complexity-O(n)
	 */
	public static void pathSumHelper(BinaryTreeNode root,int currsum,List<Integer> currList) {
	
		if(root!=null) {
			currList.add(root.getData());
			currsum=Math.abs(currsum-root.getData());
			if(currsum==0) {
				List<Integer> tempList=new ArrayList<>();
				tempList.addAll(currList);
				result.add(tempList);
				//remove the last element in the list as this list can be used while recurison(go to different sub tree apart from this path)
				//in recursion the rest of root element of left or right sub trees also gets removed .
				//ex:In the path [5, 4, 11, 2]. 4 is part of this successfull path, but needs to be removed for the path
				//[5, 8, 4, 5] when its(4) leaf nodes fail the conditions. 
				currList.remove(currList.size()-1);
				return;
			}
			pathSumHelper(root.getLeftNode(), currsum, currList);
			pathSumHelper(root.getRightNode(), currsum, currList);
		} else if(root==null) {
			return;
		}
		//remove the last element of the list if the condition currsum==0 fails for each recurison level i.e for leaf node or previous added part of a satisfied path in the list
		
		currList.remove(currList.size()-1);
	}
	
}
