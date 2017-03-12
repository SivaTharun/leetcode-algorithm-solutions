package com.graphs.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestpathinaBinaryMaze {

	static int[][] offsetArray={{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) {
		
		int[][] maze=new int[][]{{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
			{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			{1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
			{1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
			int src=3;
			int dest=4;
		System.out.println(getShortestPathInBinaryMaze(maze,src,dest));
		
	}
	
	public static int getShortestPathInBinaryMaze(int[][] maze,int src,int dest) {
		boolean[][] visited=new boolean[maze.length][maze[0].length];
        
		return BFShelper(0, maze,visited, src, dest);
		
	}
	
	/**
	 * Time Complexity-O(m*n)
	 * m-no of rows,n-no of columns
	 */
	public static int BFShelper(int distance,int[][] maze,boolean[][] visited,int src,int dest) {
		Queue<Cell> queue=new LinkedList<>();
		Cell start=new Cell(0, 0,0);
		queue.offer(start);
		visited[0][0]=true;
		while(true&&!queue.isEmpty()) {
			Cell current=queue.poll();
			for(int[] d1:offsetArray) {
				int r1=current.row+d1[0];
				int c1=current.col+d1[1];
				if(r1<0||r1>maze.length-1||c1<0||c1>maze[0].length-1||maze[r1][c1]==0||visited[r1][c1]) continue;
				if(r1==src&&c1==dest){
					
					return current.distance+1;
				}
				visited[r1][c1]=true;
				queue.offer(new Cell(r1,c1,current.distance+1));
			}
		}
		return -1;
		
	}
}
