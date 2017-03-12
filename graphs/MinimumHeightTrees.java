package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 310. Minimum Height Trees 
 *  For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5

return [3, 4] 
 * @author SivaTharun
 *
 */
public class MinimumHeightTrees {

	public static void main(String[] args) {
		
		/*int n=4;
		int[][] edges=new int[][]{{1,0},{1,2},{1,3}};*/
		int n=6;
		int[][] edges=new int[][]{{0,3},{1,3},{2,3},{4,3},{5,4}};
		System.out.println(findMinHeightTrees(n, edges));
	}

	/**
	 * Time Complexity-O(n),since in a tree the no of edges are n-1 for n vertices.
	 * space complexity-O(n)
	 * 
	 * This algorithms is similar to topological sort,instead of looking for the vertices having indegree 0.
	 * we look for the vertices with indegree 1,since these vertices are the leaves of the tree.
	 * we keep on removing the leaves from the graph,till we reach the root vertex.
	 * 
	 */
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		
		Map<Integer,List<Integer>> adjacentMap=new HashMap<>();
		for(int i=0;i<n;i++) {
			adjacentMap.put(i, new ArrayList<>());
		}
		int[] indegree=new int[n];
		for(int[] temp:edges) {
			List<Integer> adjacentList1=adjacentMap.get(temp[0]);
			adjacentList1.add(temp[1]);
			indegree[temp[1]]++;
			indegree[temp[0]]++;
			List<Integer> adjacentList2=adjacentMap.get(temp[1]);
			adjacentList2.add(temp[0]);
			adjacentMap.put(temp[0], adjacentList1);
			adjacentMap.put(temp[1], adjacentList2);
		}
		List<Integer> leafs=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(indegree[i]==1){leafs.add(i);}
		}
		
		while(n>2) {
			n=n-leafs.size();
			List<Integer> newleaves=new ArrayList<>();
			for(int temp:leafs) {
				List<Integer> neighbours=adjacentMap.get(temp);
				for(int i=0;i<neighbours.size();i++) {
					indegree[neighbours.get(i)]--;
					if(indegree[neighbours.get(i)]==1) {
						newleaves.add(neighbours.get(i));
					}
				}
			}	
			
			leafs=newleaves;
		}
		
		return leafs;
    }
}
