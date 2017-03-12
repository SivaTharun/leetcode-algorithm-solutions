package com.trees.practice;

import java.util.HashMap;
import java.util.Map;

/**
 *  106. Construct Binary Tree from Inorder and Postorder Traversal 
 *  Given inorder and postorder traversal of a tree, construct the binary tree.
	Note:
	You may assume that duplicates do not exist in the tree. 
 * @author SivaTharun
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
        int[] inorder={4 ,2 ,5  ,1  ,6 ,7 ,3 ,8};
        int[] postorder={4 ,5 ,2  ,6 ,7 ,8 ,3  ,1};
        BinaryTreeNode root=buildTree(inorder, postorder);
        System.out.println(root);
	}
	
	public static BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<inorder.length;i++) {
			map.put(inorder[i], i);
		}
	 return buildTreeHelper(inorder,postorder,0,postorder.length-1,0,inorder.length-1,map);	
	}
	
	/**
	 * Time Complexity-O(N)-->for all cases as a hash map is passed that contains the in order index for that root
	 * but if we use the for loop then the worst case will appear in case of right skewed tree-->O(N^2)
	 * 
	 */
	public static BinaryTreeNode buildTreeHelper(int[] inorder, int[] postorder,int postorderstart,int postorderend,int inOrderStart,int inOrderEnd,Map<Integer,Integer> map) {
		
		if(postorderstart>postorderend||inOrderStart>inOrderEnd)
			return null;
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(postorder[postorderend]);
		int boundayIndex=-1;
		//choosing the last element in post order array as the root element,the size of postorder decreases by 1 from right side.
		boundayIndex=map.get(root.getData());
		//the last element in the post order list is the root element
		//the boundary for the post order end for the left sub tree is the number of elements that are present in the left half of inorder array
		root.setLeftNode(buildTreeHelper(inorder,postorder,postorderstart,postorderstart+boundayIndex-(inOrderStart+1),inOrderStart,boundayIndex-1,map));
		//the starting element for post order is the remaing elemnts in inorder array after the boundary index
		root.setRightNode(buildTreeHelper(inorder,postorder,boundayIndex-inOrderStart,postorderend-1,boundayIndex+1,inOrderEnd,map));
		return root;
	}
}
