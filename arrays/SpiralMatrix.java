package com.arrays.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 * @author SivaTharun
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] inputArray={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(getSpiralOrderMatrix(inputArray));
		
	}

	/**
	 * Time Complexity- O(mn)
	 * m-size of row
	 * n-size of column
	 * @param iptArray
	 * @return
	 */
	static List<Integer> getSpiralOrderMatrix(int[][] iptArray) {
		int rowBegin=0;
		int rowEnd=iptArray.length-1;
		int colBegin=0;
		int colEnd=iptArray[0].length-1;
		List<Integer> result = new ArrayList<>();
		while(rowBegin<=rowEnd&&colBegin<=colEnd) {
			//print from left to right from the top row
			for(int i=colBegin;i<=colEnd;i++) {
				result.add(iptArray[rowBegin][i]);
			}
			//increament row begin after printing fist row
			rowBegin++;
			//print the last column from the top to bottom
			for(int j=rowBegin;j<=rowEnd;j++) {
				result.add(iptArray[j][colEnd]);
			}
			//decreament col end after printing last col
			colEnd--;
			//print the last row from right to the left
			//add the if condition to check whther row begin<=row end to prevent printing duplicates in case of single row input array.
			if(rowBegin<=rowEnd){
			 for(int k=colEnd;k>=colBegin;k--) {
				 result.add(iptArray[rowEnd][k]);
			 }
			}
			//decreament row end after printing last row
			rowEnd--;
			
			//print the first column from bottom to top
			//add the if condition to check whther col begin<=col end to prevent printing duplicates in case of single col input array.
			if(colBegin<=colEnd) {
				for(int l=rowEnd;l>=rowBegin;l--) {
					result.add(iptArray[l][colBegin]);
				}
			}
			//increament col begin after printing first col
			colBegin++;
		}
		return result;
	}
}
