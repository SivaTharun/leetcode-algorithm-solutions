package com.arrays.practice;

public class UniquePaths {

	static int pathCount=0;
	public static void main(String[] args) {
		int rowCount=3;
		int colCount=7;
		int[][] dp = new int[rowCount][colCount];
		int res=getUniqueDP2(rowCount-1, colCount-1,dp);
		
		System.out.println(res);
	}

	/**
	 * DFS Solution using backtracking and recursion to reach the destination.
	 * Time Complexity-O(k^(mn))
	 * m-size of row
	 * n-size of column
	 * Space Complexity-O(1)
	 * 
	 */
	static void getUniquePaths(int row,int col,int rowCount,int colCount) {
		
		if(row<rowCount && col<colCount) {
			if(row==rowCount-1&&col==colCount-1) 
			{
				pathCount++;
				return;
			}
			//there are two paths to choose here either go the right or go down to reach the destination
			getUniquePaths(row+1, col, rowCount, colCount);
			getUniquePaths(row, col+1, rowCount, colCount);
		}
		
	}
	
	/**
	 * Time Complexity-O(mn)
	 * space Complexity-O(mn)
	 * 
	 */
	static int getUniquePathDP(int row,int col) {
		int[][] dpGrid = new int[row][col];
		//initialize the no of ways to reach the cells in the first row and column as 1,since there is only
		//one way for this path ie either right or down.
		//first column
		for(int i=0;i<row;i++) {
			dpGrid[i][0]=1;
		}
		//first row
		for(int i=0;i<col;i++) {
			dpGrid[0][i]=1;
		}
		//calculate the no of ways for each cell apart from first row and first column
		//apparently it from either the down or right part i.e i+1 or j+1
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				dpGrid[i][j]=dpGrid[i][j-1]+dpGrid[i-1][j];
			}
		}
		//the no of ways of reaching the dp[row][col] is stored in the last element.
		return dpGrid[row-1][col-1];
	}
	
	//method similar to recursion-->instead of calculating the values repeteadly we use an dp array to store the results.
	static int getUniqueDP2(int row,int col,int[][] dp) {
		if(row==0 || col==0)
			return 1;
		if(dp[row][col]!=0)
			return dp[row][col];
		dp[row][col]=getUniqueDP2(row-1, col, dp)+getUniqueDP2(row, col-1, dp);
		
		return dp[row][col];
	}
}
