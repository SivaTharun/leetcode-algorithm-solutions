package com.graphs.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity-O(ElogV)
 * Space Complexity-O(E+V)
 */
import com.graphs.practice.MinimumBinaryHeap.Node;

public class DijkstraSingleSourceShortestPathAlgorithmWeightedGraph {

	public static void main(String[] args) {
		WeightedGraphInAdjacencyListRepresentation g = new WeightedGraphInAdjacencyListRepresentation(8);
		g.addEdge(0, 1, 4);
		g.addEdge(1, 2, 8);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 9);
        g.addEdge(4, 5, 10);
        g.addEdge(2, 5, 4);
        g.addEdge(1, 7, 11);
        g.addEdge(0, 7, 8);
        g.addEdge(2, 8, 2);
        g.addEdge(3, 5, 14);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 8, 6);
        g.addEdge(6, 7, 1);
        g.addEdge(7, 8, 7);
        System.out.println(getDijkstraSingleSourceDistance(g));
        
	}
	
	public static Map<Integer,Integer> getDijkstraSingleSourceDistance(WeightedGraphInAdjacencyListRepresentation g) {
		
		MinimumBinaryHeap<Integer> minheap = new MinimumBinaryHeap<>();
		int noOfVertices=g.V;
		for(int i=0;i<noOfVertices;i++) {
			minheap.add(Integer.MAX_VALUE, i);
		}
		Map<Integer,Integer> parentMap=new HashMap<>();
		Map<Integer,Integer> distanceMap=new HashMap<>();
		parentMap.put(0, null);
		distanceMap.put(0, 0);
		minheap.decrease(0, 0);
		//time complexity of this while loop-O(V)
		while(!minheap.empty()) {
			Node current=minheap.extractMinNode();
			int vertex=(int) current.key;
			int weight=current.weight;
			List<WeightedEdge> edgeList=g.edgeMap.get(vertex);
			//update shortest distance of current vertex from source vertex
			distanceMap.put(vertex, weight);
			//iterate through all edges of current vertex
			//time complexity for this for loop is -O(E)-->since we are traversing through the all the graph vertices 
			for(WeightedEdge edge:edgeList) {
				//get the adjacent vertex
				int destinationVertex=edge.dest;
				 //if heap does not contain adjacent vertex means adjacent vertex already has shortest distance from source vertex
				if(!minheap.containsData(destinationVertex))
					continue;
				int newDistance=distanceMap.get(vertex)+edge.weight;
				//add distance of current vertex to edge weight to get distance of adjacent vertex from source vertex
				//when it goes through current vertex
				//see if this above calculated distance is less than current distance stored for adjacent vertex from source vertex
				if(minheap.getWeight(destinationVertex)>newDistance) {
					//time complexity for this decrease method-O(logv)
					minheap.decrease(destinationVertex, newDistance);
					parentMap.put(destinationVertex, (Integer) current.key);
				}
				
			}
			
		}
		
		return distanceMap;
	}
}
