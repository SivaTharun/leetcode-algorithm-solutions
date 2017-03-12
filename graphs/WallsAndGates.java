package com.graphs.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 * @author SivaTharun
 *
 */
public class WallsAndGates {
	 static int INF=Integer.MAX_VALUE;
	 static int[][] d={{-1,0},{1,0},{0,-1},{0,1}};
		
	public static void main(String[] args) {
		
		int[][] rooms=new int[][]{{INF,-1,0,INF},{INF,INF,INF,-1},{INF,-1,INF,-1},{0,-1,INF,INF}};
		//the offset matrix for the bfs to look for its neighbours
		//wallsAndGatesDFS(rooms);
		wallsAndGatesBFS(rooms);
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[0].length;j++) {
				System.out.println(rooms[i][j]);
			}
		}
	}

	/**
	 * Time Complexity-O(M*N)
	 * @param rooms
	 */
	public static void wallsAndGatesDFS(int[][] rooms) {
		if(rooms.length<=0&&rooms[0].length<=0)return;
		boolean[][]visited=new boolean[rooms.length][rooms[0].length];
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[0].length;j++) {
				//here the value of zero serves as a marker value
				if(rooms[i][j]==0) {
					DFSHelper(rooms,i,j,0,visited);
					
				}
			}
		}
		
	}
	
	public static void DFSHelper(int[][] rooms,int row,int col,int distance,boolean[][] visited) {
		if(row>rooms.length-1||row<0||col>rooms[0].length-1||col<0||rooms[row][col]==-1||visited[row][col])return;
		//backtracking condition if the current vertex is a zero
		if(distance>rooms[row][col])return;
			visited[row][col]=true;
			rooms[row][col]=distance;
			DFSHelper(rooms, row-1, col, distance+1, visited);
			DFSHelper(rooms, row+1, col, distance+1, visited);
			DFSHelper(rooms, row, col+1, distance+1, visited);
			DFSHelper(rooms, row, col-1, distance+1, visited);
		visited[row][col]=false;
	}
	
	/**
	 * Time Complexity-O(m*n)
	 * @param rooms
	 */
	public static void wallsAndGatesBFS(int[][] rooms) {
		Queue<Cell> queue=new LinkedList<>();
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[0].length;j++) {
				if(rooms[i][j]==0)queue.add(new Cell(i,j));
			}
		}
		
		while(!queue.isEmpty()) {
			Cell cell=queue.poll();
			//explore the cells neighbours
			addNeighbours(rooms, cell.row, cell.col, queue);
		}
		
	}
	
	
	public static void addNeighbours(int[][] rooms,int row,int col,Queue<Cell> queue) {
		
		for(int[] d1:d) {
			int r1=row+d1[0];
			int c1=col+d1[1];
			//backtracking condition exclude the doors too(but the doors already added in the queue in the first place) in this case
			if(r1<0||r1>rooms.length-1||c1<0||c1>rooms[0].length-1||rooms[r1][c1]!=INF) {
				continue;
			}
			//increment the value of the neigbour for the gate to 1.
			rooms[r1][c1]=1+rooms[row][col];
			//and explore its neighbous
			queue.offer(new Cell(r1,c1));
		}
		
	}
	
}
	
	




 
