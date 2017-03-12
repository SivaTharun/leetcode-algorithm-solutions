package com.arrays.practice;

/**
 * 79. Word Search
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author SivaTharun
 *
 */
public class WordSearch {

	/**
	 * Total Time Complexity-O(mn*k^4)
	 * @param args
	 */
	public static void main(String[] args) {
		char[] [] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		int row=board.length;
		int col=board[0].length;
		boolean resultFlag = false;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(wordHelper(board,word,i,j,0)) {
					resultFlag=true;
				}
					
			}
			
		}
		System.out.println(resultFlag);
	}
	
	/**
	 * Time Complexity of helper-O(k^4)-->since we have 4 choices for the letter search i.e row+1/row-1/col+1/col-1
	 * where k-length of word
	 * @param board
	 * @param word
	 * @param row
	 * @param col
	 * @param start
	 * @return
	 */
	static boolean wordHelper(char[][] board,String word,int row,int col,int start) {
		
		if(word.length()==0||board.length==0)
			return true;
		if(start==word.length())
			return true;
		if(row<0||col<0||row==board.length||col==board[0].length)
			return false;
		if(board[row][col]!=word.charAt(start))
			return false;
		char temp=board[row][col];
		//mark the current character as visited in order to avoid same character validation in forth coming row/col recursions.
		board[row][col]='0';
		boolean existFlag=wordHelper(board, word, row+1, col, start+1)||wordHelper(board, word, row-1, col, start+1)||
				wordHelper(board, word, row, col+1, start+1)||wordHelper(board, word, row, col-1, start+1);
		//put back the original character for the visited character. 
		board[row][col]=temp;
		return existFlag;
	}
}
