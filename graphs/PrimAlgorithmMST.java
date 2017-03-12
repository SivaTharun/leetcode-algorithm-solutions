package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity-O(ElogV)
 * Space Complexity-O(V+E)-->to store both the vertices(Nodes in the min heap) and the edges for the
 * weighted graph.  
 * 
 * @author SivaTharun
 *
 */
public class PrimAlgorithmMST {

	public static void main(String[] args) {
 
		int V = 9;
		WeightedGraphInAdjacencyListRepresentation g= new WeightedGraphInAdjacencyListRepresentation(V);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
		
		getPrimMST(g);
	}
	
	public static void getPrimMST(WeightedGraphInAdjacencyListRepresentation g) {
		
		MinimumBinaryHeap<Integer> minheap= new MinimumBinaryHeap<>();
		
        //map of vertex to edge which gave minimum weight to this vertex.
		Map<Integer,WeightedEdge> vertexToEdge = new HashMap<>();
		
		List<WeightedEdge> result=new ArrayList<>();
		int noOfVertex=g.V;
		for(int i=0;i<noOfVertex;i++) {
			minheap.add(Integer.MAX_VALUE, i);
		}
		//start from any random vertex
		int startVertex = 0;
		
		minheap.decrease(startVertex, 0);
		while(!minheap.empty()) {
			//extract minimum takes O(logV)
			Integer minimum=minheap.extractMin();
			WeightedEdge spanningTreeEdge=vertexToEdge.get(minimum);
			if(spanningTreeEdge!=null) {
				result.add(spanningTreeEdge);
			}
			
			//get the corresponding edges for the vertex
			List<WeightedEdge> edgeList=g.edgeMap.get(minimum);
			//since decrease key takes O(logV) time in the min heap
			//the entire for loop takes O(ElogV)
			for(WeightedEdge temp:edgeList) {
				
				int adjacentVertex=temp.dest;
				//if the neighbour is not in min heap then that is already being visited by another vertex
				if(minheap.containsData(adjacentVertex)&&minheap.getWeight(adjacentVertex)>temp.weight) {
					minheap.decrease(adjacentVertex, temp.weight);
					vertexToEdge.put(adjacentVertex, temp);
				}
				
			}
		}
		for(WeightedEdge temp:result) {
			System.out.println(temp.src+"-->"+temp.dest+"=="+temp.weight);
		}
				
	}

}
