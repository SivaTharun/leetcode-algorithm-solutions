package com.graphs.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFSTraversal {
	
	/**
	 * BFS traversals the vertices at a particular level first and then moves
	 * to the next level iff the vertices at the previous level are completely traversed,to acheive this 
	 * the BFS uses the Queue ADT to store the order of vertices in which the 
	 * vertices are to be traversed.
	 * Time Complexity-O(V+E)
	 * 
	 * 
	 */
	 static void BFS(int startVertex,int noOfVertices,Graph graph) {
		
		boolean[] visited=new boolean[noOfVertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startVertex);
		visited[startVertex]=true;
		//O(V)-->Time Complexity is due to this while loop which in turn iterate through the vertices
		while(!queue.isEmpty()) {
			int current=queue.poll();
			System.out.println(current);
			visited[current]=true;
			List<Integer> adjacencyList=graph.adjacencyListMap.get(current);
			//O(E)-->Time complexity is due to this for each loop
			for(int temp:adjacencyList) {
				if(!visited[temp]) {
					visited[temp]=true;
					queue.add(temp);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
		BFS(2, 4, g);
	}
	
}
