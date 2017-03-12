package com.graphs.practice;

import java.util.List;
import java.util.Stack;

public class GraphDFSTraversal {
	
	/**
	 * DFS traversals the vertices first which are the deepest accessible
	 * from that particular point and prints them,to acheive this
	 * DFS uses stack ADT to track the visited neighbours of the top of the stack.  
	 * Time Complexity-O(V+E)
	 * 
	 * 
	 */
	static void DFS(int startVertex,int noOfVertices,Graph graph) {
	 
		boolean[] visited = new boolean[noOfVertices];
		Stack<Integer> stack = new Stack<>();
		stack.push(startVertex);
		visited[startVertex]=true;
		//print the starting vertex that has been added to the stack.
		System.out.println(startVertex);
		while(!stack.isEmpty()) {
			int curr=stack.peek();
			List<Integer> adjacencyList=graph.adjacencyListMap.get(curr);
			int unvistedNeighbourscount=0;
		     for(int temp:adjacencyList) {
		    	 if(!visited[temp]) {
		    		 unvistedNeighbourscount++;
		    		 visited[temp]=true;
		    		 stack.push(temp);
		    		 //visit the item and print it in DFS.
		    		 System.out.println(temp);
		    	 }
		     }
		     //pop the top of the stack if the top, does not have unvisited neighbours.
		     if(unvistedNeighbourscount==0)
		     {
		    	 stack.pop();
		     }
		}
		
	}
	
	/**
	 * Backtracking implementation of dfs using recursion
	 * 
	 */
	static void DFSBacktracking(int startVertex,Graph g) {
		boolean[] visited = new boolean[g.adjacencyListMap.keySet().size()];
		DFSUtil(startVertex,g,visited);
		
		
	}
	
	static void DFSUtil(int current,Graph g,boolean[] visited) {
		if(!visited[current]) {
		System.out.println(current);
		visited[current]=true;
		List<Integer> adjacencyListofCurrent=g.adjacencyListMap.get(current);
		for(int temp:adjacencyListofCurrent) {
			DFSUtil(temp, g, visited);
		}
		}else {
			//base condition for backtracking
			return;
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
        
		//DFS(2, 4, g);
        DFSBacktracking(2, g);
	}

}
