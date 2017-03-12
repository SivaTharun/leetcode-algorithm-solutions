package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class TopologicalSortingDAG {
	
	/**
	 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
	 * vertex u comes before v in the ordering. 
	 * Topological Sorting for a graph is not possible if the graph is not a DAG.
	 * The above algorithm is simply DFS with an extra stack. So time complexity is same as DFS which is O(V+E).
	 * Topological Sorting vs Depth First Traversal (DFS):
	 * In DFS, we print a vertex and then recursively call DFS for its adjacent vertices. 
	 * In topological sorting, we need to print a vertex before its adjacent vertices(hence we use a stack to store the vertices,whose neighbours are already visited.)
	 * The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).
	 * ***Imp: In topological sorting the vertices are ordered according to their in-degree(least in-degree first)  
	 */
	static Stack<Integer> getTopologicalSort(Set<Integer> graphSet,Graph g) {
		Set<Integer> visitedSet = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for(int vertex:graphSet) {
			//if the vertex is visited,then continue to the next vertex of the graph.
			if(visitedSet.contains(vertex))
				continue;
			else 
			{
				RecursiveTopologicalutil(visitedSet,vertex,stack,g);
			}
		}
		return stack;
	}
	
	static void RecursiveTopologicalutil(Set<Integer> visitedSet,int vertex,Stack<Integer> stack,Graph g) {
		//push the vertex onto the visited set after visiting it
		visitedSet.add(vertex);
		List<Integer> edges=g.adjacencyListMap.get(vertex);
		//iterate through the edges of the vertex and check
		//whether it is a visited one or not,if yes continue to the next edge 
		//if not call the recursive topological util method on this vertex an visit its neighbours(similar to dfs)
		for(int tempEdge:edges) {
			if(visitedSet.contains(tempEdge)) {
				continue;
			}
			RecursiveTopologicalutil(visitedSet, tempEdge, stack, g);
		}
		//push the vertex onto the stack if all its corresponding neighbours have been visited.
		//the vertex with least incoming edges will be on top of the stack and will be 
		//visited first in the topological sorting.
		stack.push(vertex);
	}
	public static void main(String[] args) {
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                "sort of the given graph");
        Set<Integer> graphSet = g.adjacencyListMap.keySet();
        Stack<Integer> stack=getTopologicalSort(graphSet, g);

        while(!stack.isEmpty()) {
        	System.out.println(stack.pop());
        }
        
        List<Integer> output=topologicalSortBFS(g);
        System.out.println(output);
	}

	/**
	 * Performing a topological sort using BFS 
	 * 
	 */
	static List<Integer> topologicalSortBFS(Graph g) {
		
	Map<Integer,Integer> inComingEdgesMap=new HashMap<>();
	Map<Integer,List<Integer>> adjacencyMap=g.adjacencyListMap;
	
	for(int i=0;i<adjacencyMap.size();i++) {
		inComingEdgesMap.put(i, 0);
	}
	
	//Time Complexity for constructing this map-O(V+E)
	for(int i=0;i<adjacencyMap.size();i++) {
		List<Integer> adjacencyList=adjacencyMap.get(i);
		for(int temp:adjacencyList) {
			int current=inComingEdgesMap.get(temp);
			inComingEdgesMap.put(temp, current+1);
		}
	}
	ArrayList<Integer> output=new ArrayList<>();
	//iterate through the incoming edge map
	//add the vertices whose incoming edges are zero to the output list and for 
	//the remaining vertices decrease the incoming edges by one,since the zero incoming edged vertices are
	//removed and add to output list,continue this process until the map is empty.
	//Time Complexity -O(E)-->this while loop runs until an vertex has at least one incoming edge so,
	//it runs for the entire edge count for the graph
	while(!inComingEdgesMap.isEmpty()) {  
		List<Integer> tempList=new ArrayList<>();
		Set<Integer> incomingEdgeSet=inComingEdgesMap.keySet();
		Iterator<Integer> incomingEdgeSetIterator=incomingEdgeSet.iterator();
		while(incomingEdgeSetIterator.hasNext()) {
			int temp=incomingEdgeSetIterator.next();
			if(inComingEdgesMap.get(temp)==0) {
				tempList.add(temp);
				incomingEdgeSetIterator.remove();
			} else {
				int currentIncomingEdges=inComingEdgesMap.get(temp);
				inComingEdgesMap.put(temp, currentIncomingEdges-1);
			}
		}
		output.addAll(tempList);
	}
		return output;
	}
}
