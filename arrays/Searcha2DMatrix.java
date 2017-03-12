package com.arrays.practice;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
 * @author SivaTharun
 *
 */
public class Searcha2DMatrix {

	public static void main(String[] args) {
		int[][] matrix= new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchElementInMatrix2(matrix,37));
	}
	
	/**
	 * Time Complexity-O((n)^2lognbase2)-->since there are two ways of searching an target,if found in same row or else then have increament the row.
	 * 
	 * 
	 *  
	 */
	static boolean searchElementIn2DArray(int row,int col,int target,int[][] matrix) {
		if(row>=matrix.length)
			return false;
		if(target==matrix[row][col])
			return true;
		else if(target<matrix[row][col]) {
			return false;
		}else if(target>matrix[row][col]) {
			//two conditions here as the target may be in the same row or in the next row
			//if in the same row first perform binary search if not found then search in next row
			int rowLength = matrix[row].length;
			if(matrix[row][rowLength-1]>target) {
			int[] currentRow=matrix[row];
			int low=0;
			int high=currentRow.length-1;
			int mid=low+(high-low)/2;
			while(low<high){
				if(currentRow[mid]==target)
					return true;
				else if(target>currentRow[mid]) {
					low=mid+1;
				}else if(target<currentRow[mid]) {
					high=mid-1;
				}
				mid=low+(high-low)/2;
			}
			} else if(target==matrix[row][rowLength-1]) {
				return true;
				
			}else if(target>matrix[row][rowLength-1]) {
			//if not found in this row then go for the next row.
			boolean nextRowFlag=searchElementIn2DArray(row+1, col, target, matrix);
			
			if(nextRowFlag)
				return true;
		}
		}
		return false;
	}
	
	/**
	 *We start search the matrix from top right corner, initialize the current position to top right corner, 
	 *if the target is greater than the value in current position, 
	 *then the target can not be in entire row of current position because the row is sorted, 
	 *if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. 
	 *We can rule out one row or one column each time, so the time complexity is O(m+n).
	 * 
	 *  Time Complexity-O(m+n),where m-row size,n-col size
	 *  Space Complexity-O(1)
	 * 
	 */
	static boolean searchElementInMatrix(int[][] matrix,int target) {
		
		int totRow=matrix.length;
		int totCol=matrix[0].length;
		int row=0;
		int col=totCol-1;
		while(row<totRow&&col>=0) {
			
			if(matrix[row][col]==target)
				return true;
			else if(matrix[row][col]>target) {
				col--;
			}else if(matrix[row][col]<target) {
				row++;
			}
		}
		
		return false;
	}
	
	static boolean searchElementInMatrix2(int[][] matrix,int target) {
		
		if(matrix.length==0||matrix==null)
			return false;
			
		int totRow=matrix.length;
		int totCol=matrix[0].length;
		return helper(0,totRow-1,0,totCol-1,target,matrix);
		
	}

	/**
	 *
	 *  A divide-and-conquer solution:
		We could divide the entire matrix by a 4 x 4 panel, i.e, upper-left, upper-right, lower-left and lower-right. 
 		-- If the target is equal to the middle, i.e, 9 in the example above, then we are done. 
 		-- If the target is less than 9, then the lower-right part would be eliminated. 
 		-- If the target is greater than 9, the upper-left part would be eliminated. 
	 * 
	 * 
	 * 
	 */
	static boolean helper(int rowStart,int rowEnd,int colStart,int colEnd,int target, int[][] matrix) {
		
		if(rowStart>rowEnd||colEnd<colStart) {
			return false;
		}
		//apply binary search technique to find the mid row/col
		int rowMid=rowStart+(rowEnd-rowStart)/2;
		int colMid=colStart+(colEnd-colStart)/2;
		
		if(matrix[rowMid][colMid]==target)
			return true;
		else if(matrix[rowMid][colMid]>target) {
			return helper(rowStart, rowEnd-1, colStart, colEnd-1, target, matrix)||helper(rowStart, rowEnd-1, colStart, colEnd, target, matrix)||
					helper(rowStart, rowEnd, colStart, colEnd-1, target, matrix);
		}
		else if(matrix[rowMid][colMid]<target) {
			return helper(rowStart+1, rowEnd, colStart+1, colEnd, target, matrix)||helper(rowStart+1, rowEnd, colStart, colEnd, target, matrix)||
					helper(rowStart, rowEnd, colStart+1, colEnd, target, matrix);
		}
		return false;
	}
}
