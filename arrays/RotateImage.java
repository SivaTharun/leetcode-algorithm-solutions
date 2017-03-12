package com.arrays.practice;

/**
 *  48. Rotate Image 
 *  You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * @author SivaTharun
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		int[][] input={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(getRotatedImage(input));
		
	}
	
	//Time Complexity-O(m*n)
	//m-no of rows
	//n-no of columns
	//Method using an transpose matrix and swapping along rows/columns
	static int[][] rotateImage(int[][] input) {
		
		//transpose the matrix first
		
		for(int i=0;i<input.length;i++) {
			//consider the upper triangle of the array to swap with the upper half
			//anyways the diagonal path remains unswapped
			for(int j=i;j<input[0].length;j++) {
				int temp=input[i][j];
				input[i][j]=input[j][i];
				input[j][i]=temp;
			}
		}
		//after the transpose the matrix is swapped horizontally or vertically
		//depending on the type of rotation (clock or anti clock).
		//for clock wise rotation the flipping is horizontal
		//the columns have to be swapped
		for(int k=0;k<input.length;k++) {
			//swapping along the row length
			//so varying the column length but keeping the row values as constant
			//here we are swapping first and last row/column itself leaving the middle row/column values 
			//undisturbed so taking the limit of swap to input.length/2.
			for(int w=0;w<input.length/2;w++) {
				int temp=input[k][w];
				input[k][w]=input[k][input.length-1-w];
				input[k][input.length-1-w]=temp;
			}
		}
		return input;
	}
	
	/**
	 * Time Complexity-O(m*n)
	 * Space Complexity-O(1)
	 * We start by rotating the outer edges:

tmp = image[0][0];
image[0][0] = image[3][0];
image[3][0] = image[3][3];
image[3][3] = image[0][3];
image[0][3] = tmp;
tmp = image[0][1];
image[0][1] = image[2][0];
image[2][0] = image[3][2];
image[3][2] = image[1][3];
image[1][3] = tmp;
After doing the outer edge, we notice a pattern that can be represented by this code:
	
for(int i=0; i < N-1; i++) {
	tmp = image[0][i];
	image[0][i] = image[N-1-i][0];
	image[N-1-i][0] = image[N-1][N-1-i];
	image[N-1][N-1-i] = image[i][N-1];
	image[i][N-1] = tmp;
}

Now we have to apply the same algorithm on the inner edges, so we wrap the above loop in another loop with some modification to reduce the width and height of the new inner matrix.

 matrix[i][j] <--- matrix[n-1-j][i];
matrix[n-1-j][i] <--- matrix[n-1-i][n-1-j];
matrix[n-1-i][n-1-j] <--- matrix[j][n-1-i];
matrix[j][n-1-i] <--- matrix[i][j];
	 * 
	 */
	static int[][] rotateArrayGenericMethod(int[][] input) {
		
		int rowLength=input.length;
		int colLength=input[0].length;
		for(int i=0;i<rowLength/2;i++) {
			//since row length=column length for a square matrix,the
			//value of column will move from all column values for i=0. i.e outer elements
			//and will decrease by 1 for inner elements.
			for(int j=i;j<colLength-1-i;j++) {
				int temp=input[i][j];
				input[i][j]=input[rowLength-1-j][i];
				input[rowLength-1-j][i]=input[rowLength-1-i][colLength-1-j];
				//the elements input[j][colLength-1-i] and input[rowLength-1-j][i] are mirror images so after 
				//swapping input[rowLength-1-j][i] we should swap input[j][colLength-1-i]
				input[rowLength-1-i][colLength-1-j]=input[j][colLength-1-i];
				//swap with the first element input[i][j]
				input[j][colLength-1-i]=temp;
			}
		}
		
		return input;
	}
	
	/**
	 * Same as first method but here we do swapping and 
	 * transpose alternately.
	 * 
	 */
	static int[][] getRotatedImage(int[][] input) {
		
		int rowLength=input.length;
		int colLength=input[0].length;
		//swap the rows in first and last position
		for(int i=0;i<rowLength/2;i++) {
			for(int j=0;j<colLength;i++) {
				int temp=input[i][j];
				input[i][j]=input[rowLength-1-i][j];
				input[rowLength-1-i][j]=temp;
			}
		}
		//transpose the matrix
		for(int i=0;i<rowLength;i++) {
			for(int j=i;j<colLength;j++) {
				int temp=input[i][j];
				input[i][j]=input[j][i];
				input[j][i]=temp;
			}
		}
		
		return input;
	}
	
}		
 