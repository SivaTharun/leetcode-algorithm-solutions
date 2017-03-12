package com.graphs.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Time Complexity for this algorithm-O(N) where nis the total no of union and findset opearions-->typically since the cycle will be detected if we traverse through the graph for the vth vertex
 * Space Complexity-O(V)-->make V number of individual disjoint sets 
 *  
 */
public class CycleinaDirectedGraphUsingDisjoinSets {

	public static void main(String[] args) {
		//Graph g = new Graph(6);
        /*g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
*/        
		//graph has cycle
        Graph g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(ISCycleDetectedInaGraph(g));
	}
	
	public static boolean ISCycleDetectedInaGraph(Graph g) {
		int numVertex = g.adjacencyListMap.keySet().size();
		int[] parent=new int[numVertex];
		int[] rank = new int[numVertex]; 
		DisjointSets ds = new DisjointSets(parent, rank, numVertex);
		Set<Integer> vertexSet = new HashSet<>();
		vertexSet=g.adjacencyListMap.keySet();
		for(int temp:vertexSet) {
			List<Integer> EdgesList = g.adjacencyListMap.get(temp);
			//Iterator<Integer> edgeListIterator=EdgesList.iterator();
			for(int tempEdge:EdgesList) {
				//if the parent vertex and the child are in the same subset then there is 
				//a cycle (a different path) to reach the child from the parent
				if(ds.findSet(temp)==ds.findSet(tempEdge)) {
					return true;
				}
				else {
					ds.Union(temp, tempEdge);
				}
			}
		}
		return false;
	}

}
