package com.graphs.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CycleinaDirectedGraphDFS {

	/*public static boolean isCyclePresentInDirectedGraph(Graph g) {
		//white set represents the unvisited vertices of a graph.
		Set<Integer> whiteSet=new HashSet<>();
		//grey set  represents the vertices,which are in recursion stack.
		Set<Integer> greySet=new HashSet<>();
		//black set represents the vertices,whose neighbours are completely visited.
		Set<Integer> blackSet=new HashSet<>();
		Iterator<Integer> itr=g.adjacencyListMap.keySet().iterator();
		while(itr.hasNext()) {
			whiteSet.add(itr.next());
		}
		Set<Integer> tempWhiteSet=new HashSet<>();
		for(int temp:whiteSet) {
			tempWhiteSet.add(temp);
		}
		//iterate through the vertices of the graph
		Iterator<Integer> WhiteSetIterator=whiteSet.iterator();
		while(WhiteSetIterator.hasNext()) {
		int current=WhiteSetIterator.next();
		  if(dfsUtil(current, tempWhiteSet, greySet, blackSet,g))
			  return true;
		}
		return false;
	}
	*/
	/**
	 * Need to revisit the recursion logic for grey set
	 * 
	 *//*
	public static boolean dfsUtil(Integer current,Set<Integer> whiteSet,Set<Integer> greySet,Set<Integer> blackSet,Graph g) {
		//move the current vertex from whiteset to greyset
		moveElementFromSourceToDestination(current, whiteSet, greySet);
		List<Integer> neighbours=g.adjacencyListMap.get(current);
		//iterate through the neighbours of a set
		if(neighbours.size()!=0) {
		for(int temp:neighbours) {
			if(blackSet.contains(temp))continue;
			if(greySet.contains(temp)) return true;
			else
			return dfsUtil(temp, whiteSet, greySet, blackSet, g);
			
		}
		}
		//move the vertex from greyset to blackset,to mark the vertex as visited
		moveElementFromSourceToDestination(current, greySet, blackSet);
		return false;
	}
	static void moveElementFromSourceToDestination(Integer element,Set<Integer> sourceSet,Set<Integer> destinationSet) {
		sourceSet.remove(element);
		destinationSet.add(element);
	}*/
	
	/**
	 * Time Complexity-O(V+E)
	 * Mark an array for recursion set to store the current
	 * elements in recursion stack.
	 *  
	 * 
	 */
	static boolean isCycleDetectedinDirectedGraph(Graph g) {
		boolean[] visitedSet=new boolean[g.adjacencyListMap.keySet().size()];
		boolean[] recursionSet=new boolean[g.adjacencyListMap.keySet().size()];
		Set<Integer> graphKeySet=g.adjacencyListMap.keySet();
		for(int temp:graphKeySet) {
			if(visitedSet[temp])continue;
			if(dfsUtil(visitedSet,recursionSet,temp,g))
				return true;
		}
		return false;
	}
	static boolean dfsUtil(boolean[] visitedSet,boolean[] recursionSet,int current,Graph g) {
		visitedSet[current]=true;
		recursionSet[current]=true;
		List<Integer> neighbours=g.adjacencyListMap.get(current);
		for(int temp:neighbours) {
			//if the current neighbour is in recursion stack,then a cycle is detected from the child to parent
			//mean there are more than one way to reach from child to parent
			if(recursionSet[temp])return true;
			//check for the recursive dfs for the current neighbour of the parent
			else if(dfsUtil(visitedSet, recursionSet, temp, g))
			 return true;
		}
		//remove the parent from recursion stack,once all its children are visited.
		recursionSet[current]=false;
		//return false if no cycle is found
		return false;
	}
	public static void main(String[] args) {
		
		/*Graph g = new Graph(6);
        g.addEdge(5, 2);
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
        System.out.println(isCycleDetectedinDirectedGraph(g));
	}

}
