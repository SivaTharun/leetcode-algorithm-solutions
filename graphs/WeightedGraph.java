package com.graphs.practice;

public class WeightedGraph {
	
	int V,E;//-->no of vertices and the edges
	Edge edge[];//-->the edge list represenation of the graph
	
	class Edge implements Comparable<Edge> {
       int src,destination,weight;
		@Override
		public int compareTo(Edge edge) {
			// TODO Auto-generated method stub
			return this.weight-edge.weight;
		}
		
	};
	
	public WeightedGraph(int v, int e) {
		this.V=v;
		this.E=e;
		this.edge=new Edge[E];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();
					
		}
	}

}
