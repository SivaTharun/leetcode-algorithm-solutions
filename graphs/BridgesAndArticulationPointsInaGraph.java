package com.graphs.practice;

import java.util.List;

/**
 * Printing the bridges and articulation points of the graph based on tarjan's algorithm
 * @author SivaTharun
 *
 */
public class BridgesAndArticulationPointsInaGraph {

	static int time =0;
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        getGraphBridges(g1);
	}
	
	public static void getGraphBridges(Graph g) {
		
		boolean[] visited=new boolean[g.adjacencyListMap.size()];
		int[] disc=new int[g.adjacencyListMap.size()];
		int[] low=new int[g.adjacencyListMap.size()];
		int[] parent=new int[g.adjacencyListMap.size()];
		//boolean array to mark for the articulation points in the graph
		boolean[] isArticulatePoint=new boolean[g.adjacencyListMap.size()];
		for(int i=0;i<g.adjacencyListMap.size();i++) {
			parent[i]=-1;
		}
		
		for(int i=0;i<g.adjacencyListMap.size();i++) {
			if(!visited[i]) 
				DFSArticulationPointUtil(i, parent, visited, disc, low,g,isArticulatePoint);	
		}
  
		System.out.println("The articulation points in the graph are: ");
		for(int i=0;i<isArticulatePoint.length;i++) {
			if(isArticulatePoint[i])System.out.println(i);
		}
		
	}
	
	/*
	 * Time Complexity-O(E+V)
	 * Space Complexity-O(V)
	 */
	public static void DFSBridgeUtil(int currentVertex,int[] parent,boolean[] visited,int[] disc,int[] low,Graph g) {
		
		visited[currentVertex]=true;
		disc[currentVertex]=low[currentVertex]=time;
		time++;
		List<Integer> neighbours=g.adjacencyListMap.get(currentVertex);
		
		for(int temp:neighbours) {
			if(!visited[temp]) {
			//this code is for the parent and child vertex 
			parent[temp]=currentVertex;
			DFSBridgeUtil(temp, parent, visited, disc, low, g);
			
			//updating the parent vertex low reachable time to the low reachable time of the child,since parent can reach the child
			low[currentVertex]=Math.min(low[currentVertex], low[temp]);
			
			//if low reachable time of child is greater than parent's discovery then both of them constitute a bridge
			//since the low will be updated to a lower value iff there is any back edge in graph from child to parent
			if(low[temp]>disc[currentVertex]) {
				System.out.println("The Edge "+currentVertex +"----"+temp+" is a bridge");
			}
			//if the vertex is already visited but not from current vertex then update the low reachable time of 
			//current vertex
			} else if(currentVertex!=parent[temp]) {
				low[currentVertex]=Math.min(low[currentVertex], disc[temp]);
			}
		}
		
	}

	/**
	 * Time Complexity-O(E+V)
	 * Space Complexity-O(V)
	 */
	public static void DFSArticulationPointUtil(int currentVertex,int[] parent,boolean[] visited,int[] disc,int[] low,Graph g,boolean[] isArticulatePoint) {
		visited[currentVertex]=true;
		disc[currentVertex]=low[currentVertex]=time;
		time++;
		List<Integer> neighbours=g.adjacencyListMap.get(currentVertex);
		int children=0;
		for(int temp:neighbours) {
			if(!visited[temp]) {
			//this code is for the parent and child vertex 
			parent[temp]=currentVertex;
			children++;
			DFSArticulationPointUtil(temp, parent, visited, disc, low, g,isArticulatePoint);
			
			//updating the parent vertex low reachable time to the low reachable time of the child,since parent can reach the child
			low[currentVertex]=Math.min(low[currentVertex], low[temp]);
			
			//the current vertex is an articulation point iff
			//1)if it is an root node and has atleast two independent children
			//2)else,if not a root then the low[child]>=disc[parent]
			
			//check for condition 1 if the parent is a root node and has more than one children
			if(parent[currentVertex]==-1&&children>1){
				isArticulatePoint[currentVertex]=true;
			  }
			
			//if low reachable time of child is greater than parent's discovery then both of them constitute a bridge
			//since the low will be updated to a lower value iff there is any back edge in graph from child to parent
			if(low[temp]>=disc[currentVertex]) {
				isArticulatePoint[currentVertex]=true;
			}
				
			//if the vertex is already visited but not from current vertex then update the low reachable time of 
			//current vertex
			} else if(currentVertex!=parent[temp]) {
				low[currentVertex]=Math.min(low[currentVertex], disc[temp]);
			}
		}
	}
}
