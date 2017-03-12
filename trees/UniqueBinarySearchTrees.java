package com.trees.practice;

/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author SivaTharun
 *
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n=3;
		System.out.println(numTreesDP(n));

	}
	
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

The outer loop compute all trees[n]. The inner loop compute each of these using the decomposition I shown above (and the computations of all the values before n).
     *
	 */
	
	/**
	 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.

1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).

2) Count the number of possible Binary Search Trees with n keys (See this)

3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
Recursive Solution
Catalan numbers satisfy the following recursive formula.
  C0=1 and Cn+1=sigma i=0 to n(C(i)*c(n-i))
  
  In “Unique Binary Search Trees”, we are only required to output the number of the trees. 
  We know that all nodes in the left subtree are smaller than the root. And all nodes in the right subtree are larger than the root. 
  For a integer n, we have n options to be the root. In these options, assuming i is the value that we choose to be the root. The value in left subtree are from 1 to i – 1, and the values in right subtree are from i + 1 to n. 
  If 1 to i – 1 can form p different trees, and i + 1 to n can form q different trees, then we will have p * q trees when i is the root. 
  In fact, the number of different trees depends on how many number to form the tree.
  
  Time Complexity-Time complexity of above implementation is equivalent to nth catalan number.
  The value of nth catalan number is exponential that makes the time complexity exponential.
 */
  public static int numTrees(int n) {
	int res=0;
	  if(n<=1)return 1;
	  else{
		  //the value of total left nodes ranges from 0 to n-1.
		  for(int i=0;i<n;i++) {
			  //always consider one root node for the two left and right sub trees.
			  //so for total nodes of n the no of nodes that form left or right sub trees are n-1.
			  res+=numTrees(i)*numTrees(n-1-i);
		  }
		  return res;
	  }
  }
  
  
  /**
   * 
   * @param n
   * @return
   */
  public static int numTreesDP(int n) {
	  
	  int[] catalanDP = new int[n+1]; 
	  catalanDP[0]=1;
	  catalanDP[1]=1;
	  for(int i=2;i<=n;i++) {
		  //instatiate the current value to be 0
		  catalanDP[i]=0;
		  //calculate the catalan value for the nth value based on the summation formula for catalan number
		  for(int j=0;j<i;j++) {
			  catalanDP[i]+=catalanDP[j]*catalanDP[i-j-1];
		  }
	  }
	  return catalanDP[n];
  }
}
