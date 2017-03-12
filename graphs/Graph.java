package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph Representation in Adjacency list format. 
 * 
 * @author SivaTharun
 *
 */
public class Graph {
	
	//the no of vertices in the graph
	private int V;
	//adjacency list map  that is used to store the map with the vertex as the key and its adjacency list as the value.
	public Map<Integer,List<Integer>> adjacencyListMap=new HashMap<>();
	
	//constructor for initializing a graph
	Graph(int v) {
		V=v;
		for(int i=0;i<V;i++) {
			adjacencyListMap.put(i, new ArrayList<Integer>());
		}
	}
	
	//method for adding an edge in a graph
	void addEdge(int v,int w) {
		adjacencyListMap.get(v).add(w);
	}
}
