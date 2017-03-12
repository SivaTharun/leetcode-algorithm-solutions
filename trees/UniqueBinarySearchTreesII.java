package com.trees.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author SivaTharun
 *
 */
public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		int n=3;
		List<BinaryTreeNode> treeList=generateTrees(n);
		for(BinaryTreeNode curr:treeList) {
			System.out.println(curr);
		}
	}
	
	public static List<BinaryTreeNode> generateTrees(int n) {
		if(n==0)return new ArrayList<BinaryTreeNode>();
		return genearteTreesHelper(1, n);
	}
	
	/**
	 * Time Complexity-Time complexity of above implementation is equivalent to nth catalan number.
	 * To evaluate the complexity, let us focus on the number of recursive calls performed, let C(n).
     *
	 *	A call for n implies exactly 2(n-1) recursive calls(for both left and right sub trees), each of them adding their own costs, 2(C(1)+C(2)+...C(n-1)).
	 *  A call for n+1 implies exactly 2n recursive calls, each of them adding their own costs, 2(C(1)+C(2)+...C(n-1)+C(n)).
     *
	 * By difference, C(n+1)-C(n) = 2+2C(n), which can be written C(n) = 2+3C(n-1).

C(1) = 0
C(2) = 2+2C(1) = 2+3C(0) = 2
C(3) = 4+2(C(1)+C(2)) = 2+3C(2) = 8
C(3) = 6+2(C(1)+C(2)+C(3)) = 2+3C(3) = 26
C(4) = 8+2(C(1)+C(2)+C(3)+C(4)) = 2+3C(4) = 80
...
C(n) = 2n-2+2(C(1)+C(2)+...C(n-1)) = 2+3C(n-1)

To solve this recurrence easily, notice that

C(n)+1 = 3(C(n-1)+1) = 9(C(n-2)+1) = ...3^(n-2)(C(2)+1) = 3^(n-1)

Hence, for n>1 the exact formula is

C(n) = 3^(n-1)-1

The number of calls to Catalan(1) (constant time), is also C(n), and the numbers of adds or multiplies are C(n)/2 each.

It is easy to reduce the complexity from O(3^n) to O(2^n) by noting that all terms in the loop (except the middle one) are computed twice - but that still doesn't make it an acceptable implementation 
	 * 
	 */
	public static List<BinaryTreeNode> genearteTreesHelper(int start,int end) {
		List<BinaryTreeNode> treeList = new ArrayList<>();
		if(start>end) {
			//corner condition iff all the nodes in the left/right sub tree are used up,then return empty tree to the list.
			treeList.add(null);
			return treeList;
		}
		//choosing the values from start to end as the root node
		for(int i=start;i<=end;i++) {
			//choose the ith node as the root and generate left and right sub trees for the same root 
			List<BinaryTreeNode> leftTrees=genearteTreesHelper(start, i-1);
			List<BinaryTreeNode> rightTrees=genearteTreesHelper(i+1, end);
			//since from the piniciple of catalan number
			/**
			 * trees[n] is the number of trees with exactly n nodes. 
	 * There is 1 trees with 0 nodes, hence trees[0] == 1. 
	 * For a given n > 0 there is a root node and two children trees whose total size is: n-1
     *
    trees[n-1] possible trees on the left and trees[0] on the right
    trees[n-2] possible trees on the left and trees[1] on the right
    ...
    trees[1] possible trees on the left and trees[n-1-1] on the right
    trees[0] possible trees on the left and trees[n-1] on the right

When you have trees[k] possible trees on the left, and trees[l] on the right, it makes trees[k]*trees[l] possible combinations. This means:

trees[n] = trees[n-1]*trees[0]
         + trees[n-2]*trees[1]
         + ...
         + trees[1]*trees[n-2]
         + trees[0]*trees[n-1]
			 */
			//similarly construct the trees using the baove principle using two loops 
			for(BinaryTreeNode currRight:rightTrees) {
				for(BinaryTreeNode currLeft:leftTrees) {
					//construct the tree with i as root node
					BinaryTreeNode rootNode = new BinaryTreeNode();
					rootNode.setData(i);
					//set the left and right sub tree for the root 
					rootNode.setLeftNode(currLeft);
					rootNode.setRightNode(currRight);
					treeList.add(rootNode);
				}
			}
		}
		return treeList;
	}
}
