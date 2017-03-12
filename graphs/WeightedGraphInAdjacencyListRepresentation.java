package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphInAdjacencyListRepresentation {
	int V;
	Map<Integer,List<Integer>> adjacencyListMap = new HashMap<>();
	Map<Integer,List<WeightedEdge>> edgeMap=new HashMap<>();
	public void addEdge(int src,int dest,int weight) {
		WeightedEdge we = new WeightedEdge(src, dest, weight);
		List<Integer> adjacencyList=adjacencyListMap.get(src);
		adjacencyList.add(dest);
		adjacencyListMap.put(src, adjacencyList);
		List<WeightedEdge> edgeList=edgeMap.get(src);
		edgeList.add(we);
		edgeMap.put(src, edgeList);
		
	}
	public WeightedGraphInAdjacencyListRepresentation(int vertices) {
		int totalVertices=vertices;
		this.V=vertices;
		for(int i=0;i<totalVertices;i++) {
			adjacencyListMap.put(i, new ArrayList<Integer>());
		}
		for(int i=0;i<totalVertices;i++) {
			edgeMap.put(i, new ArrayList<WeightedEdge>());
		}
	}
	
	public int getEdgeWeight(int src,int dest) {
		List<WeightedEdge> weightedEdgeList=edgeMap.get(src);
		int edgeWeight=0;
		for(WeightedEdge temp:weightedEdgeList) {
			if(dest==temp.dest)
				edgeWeight= temp.weight;
		}
		return edgeWeight;
	}
}
