package com.arrays.practice;

/**
 * Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths would there be?

	An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	For example,

	There is one obstacle in the middle of a 3x3 grid as illustrated below.

	[
  	[0,0,0],
  	[0,1,0],
  	[0,0,0]
	]

	The total number of unique paths is 2.

	Note: m and n will be at most 100.
 * @author SivaTharun
 *
 */
public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] iptArray=new int[][]{{0,0,0},{1,1,1},{0,0,0}};
		System.out.println(getUniquePath(iptArray));
	}
	
	/**
	 * 
	 * Time Complexity-O(mn)
	 * Space Complexity-O(mn)
	 * 
	 * @return
	 */
	static int getUniquePath(int[][] iptArray) {
		int row=iptArray.length;
		int col=iptArray[0].length;
		//check if the first or last element in the array is 1,if yes then no path exist.
		if(iptArray[0][0]==1 || iptArray[row-1][col-1]==1)
		return 0;
		int[][] dpArray = new int[row][col];
		//initialize the fisrt element of the dp array as 1.
		dpArray[0][0]=1;
		//assign the elements for the first column depending on the element is an obstacle or not
		for(int i=1;i<row;i++) {
			if(iptArray[i][0]!=1) {
				dpArray[i][0]=dpArray[i-1][0];
			}
		}
		//assign the elements for the first row depending on the element is an obstacle or not
		for(int j=1;j<col;j++) {
			if(iptArray[0][j]!=1) {
				dpArray[0][j]=dpArray[0][j-1];
			}
		}
		//
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(iptArray[i][j]!=1) {
					dpArray[i][j]=dpArray[i-1][j]+dpArray[i][j-1];
				} else 
					dpArray[i][j]=0;
			}
		}
		return dpArray[row-1][col-1];
	}

}
