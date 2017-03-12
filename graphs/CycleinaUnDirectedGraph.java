package com.graphs.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Since we use DFS to detect a cycle in undirected graph,
 * the time complexity would be same as DFS-O(V+E)
 *  
 *  For every visited vertex ‘v’, 
 *  if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph.
 *
 */
public class CycleinaUnDirectedGraph {

	public static void main(String[] args) {
		
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(isCycleFound(g1));
	}
	
	static boolean isCycleFound(Graph g) {
		boolean[] visited=new boolean[g.adjacencyListMap.keySet().size()];
		Set<Integer> graphVertices=g.adjacencyListMap.keySet();
		int parent=-1;
		for(int temp:graphVertices) {
			if(dfsUtil(temp, parent, g,visited));
		}
		return false;
		
	}
	
	static boolean dfsUtil(int vertex,int parent,Graph g,boolean[] visited) {
		visited[vertex]=true;
		List<Integer> neighbours=g.adjacencyListMap.get(vertex);
		Iterator<Integer> iterator=neighbours.iterator();
		while(iterator.hasNext()) {
			int i=iterator.next();
			if(!visited[i]) {
				if(dfsUtil(i, vertex, g, visited))
					return true;
				 //If an adjacent vertex is visited and not parent of current
	            // vertex, then there is a cycle.
			    //the vertex might be reached from its parent so keeping
			    //the track of parent vertex for the current recursion. 
			} else if(i!=parent) {
				return true;
			}
		}
		return false;
		}
  
}
