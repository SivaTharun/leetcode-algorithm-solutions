package com.graphs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.graphs.practice.WeightedGraph.Edge;


/**
 * Time Complexity-->O(ElogE)+O(E)=O(ElogE)
 * 
 * A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
 * 
 * Below are the steps for finding MST using Kruskal’s algorithm
 *
 *	1. Sort all the edges in non-decreasing order of their weight.
 *
 *	2. Pick the smallest edge. Check if it forms a cycle with the spanning tree 
 *	formed so far. If cycle is not formed, include this edge. Else, discard it.   
 *
 *	3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 *
 * @author SivaTharun
 *
 */
public class KrusalsAlgorithmMST {

	public static void main(String[] args) {
		WeightedGraph graph= new WeightedGraph(4, 5);
		// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;
        
        List<Edge> edgeList=getMST(graph);
        for(Edge temp:edgeList) {
        	System.out.print(temp.src+"-->"+temp.destination+"=="+temp.weight);
        	System.out.println("");
        }
		
	}
	
	public static List<Edge> getMST(WeightedGraph g) {
	int n=g.V;
	int[] parent=new int[n];
	int[] rank=new int[n];
	DisjointSets ds = new DisjointSets(parent, rank, n);
	List<Edge> resultMST=new ArrayList<>();
	Edge[] edgeArray=g.edge;
	//time complexity for sorting the edges based their weight-->O(ElogE)
	Arrays.sort(edgeArray);
	//time complexity for disjoint set for running through the edge list and
	//performing findset and union operations-->O(E)
	for(int i=0;i<edgeArray.length;i++) {
		int x=ds.findSet(edgeArray[i].src);
		int y=ds.findSet(edgeArray[i].destination);
		//if the src and destination are represented by different subsets,then
		//add that edge to the result,since the edges are already sorted
		if(x!=y) {
			resultMST.add(edgeArray[i]);
			ds.Union(x, y);
		}
		//else this is alternate self loop and hence continue by discarding the edge
	}
		return resultMST;
	}

}
