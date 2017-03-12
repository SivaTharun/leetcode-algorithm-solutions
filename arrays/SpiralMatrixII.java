package com.arrays.practice;

/**
 * 59. Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	For example,
	Given n = 3,
	You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 * @author SivaTharun
 *
 */
public class SpiralMatrixII {

	public static void main(String[] args) {
		
		int num =3;
		System.out.println(getSpiralMatrix2(num));
	}

	/**
	 * time complexity-O(n^2),where n-row size or col size for sqaure matrix
	 * @param num
	 * @return
	 */
	static int[][] getSpiralMatrix2(int num) {
		int rowBegin=0;
		int rowEnd=num-1;
		int colBegin=0;
		int colEnd = num-1;
		int i=1;
		int[][] output = new int[num][num];
		while(i<=num*num) {
			for(int j=colBegin;j<=colEnd;j++) {
				output[rowBegin][j]=i++;
			}
			rowBegin++;
			for(int k=rowBegin;k<=rowEnd;k++) {
				output[k][colEnd]=i++;
			}
			colEnd--;
			//since the resulting matrix is always a square no need 
			//to check if duplicates in this scenario like row only or column only matrix
			for(int w=colEnd;w>=colBegin;w--) {
				output[rowEnd][w]=i++;
			}
			rowEnd--;
			for(int t=rowEnd;t>=rowBegin;t--) {
				output[t][colBegin]=i++;
			}
			colBegin++;
		}
		return output;
	}
}
