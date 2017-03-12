package com.graphs.practice;

/**
 * Disjoint set DS implementation using array which supports 
 * operations of disjoint sets makeSet,findSet and union
 * 
 * @author SivaTharun
 *
 */
public class DisjointSets {
	int n;
	int[] parent=new int[n];
	int[] rank=new int[n];
	
	public DisjointSets(int[] parent, int[] rank, int n) {
		super();
		this.parent = parent;
		this.rank = rank;
		this.n = n;
		makeSet(parent, n);
	}
	
	public void makeSet(int[] parent,int n) {
		//creating individual disjoint set for each element  
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
	}
	
	//using path compression technique to
	//reduce the time complexity for future find set operations
	public int findSet(int i) {
		
		if(this.parent[i]!=i) {
			parent[i]=findSet(parent[i]);
		}
		return parent[i];
	}
	
	//using union by rank to reduce the time complexity
	//in order for the sets to make a linked list instead of a tree structure
	public void Union(int x,int y) {
		if(findSet(x)==findSet(y))
			return;
		else if(this.rank[x]>this.rank[y]) {
			this.parent[y]=x;
		} else if(this.rank[y]>this.rank[x]) {
			this.parent[x]=y;
		}else {
			//both the sets have the same rank(height) then
			//make any set the parent of the other and increase 
			//the rank of the parent set
			this.parent[y]=x;
			this.rank[x]=this.rank[x]+1;
		}
	}
}
