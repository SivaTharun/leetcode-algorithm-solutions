package com.graphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
  * There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

	For example:

	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

	2, [[1,0],[0,1]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

	Note:
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	You may assume that there are no duplicate edges in the input prerequisites.
  * 
  *
  */
public class CourseSchedule {

	public static void main(String[] args) {
		
		/*int numCourses=2;
		
		int[][] prerequisites= new int[][]{{1,0},{0,1}};*/
		
		int numCourses=4;
		int[][] prerequisites= new int[][]{{1,0},{2,0},{3,1},{3,2}};
		//System.out.println(canFinish(numCourses,prerequisites));
		System.out.println(isCourseSchedulePossibleBFStopological(prerequisites, numCourses));
	}
	
	/**
	 * The graph that is generated from the prerequisites array is an directed graph,the course schedule 
	 * will break iff there is a cycle in this graph,so we have to detect a cycle in this graph using DFS.
	 * 
	 */
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		
		int noOfEdges=prerequisites.length;
		
		//use a adjacency list representation for the graph to get the edges
		Map<Integer,List<Integer>> adjacencyListRepCourseSchedule=new HashMap<>();
		for(int i=0;i<numCourses;i++) {
			adjacencyListRepCourseSchedule.put(i, new ArrayList<Integer>());
		}
		//iterate though the prerequisites array and add the edges to the adjacency list representation
		//prerequisites.length gives the number of array having [source,destination] format
		for(int i=0;i<noOfEdges;i++) {
			ArrayList<Integer> al = (ArrayList<Integer>) adjacencyListRepCourseSchedule.get(prerequisites[i][1]);
			 al.add(prerequisites[i][0]);
			adjacencyListRepCourseSchedule.put(prerequisites[i][1],al);
		}
		
		Set<Integer> sourceSet=adjacencyListRepCourseSchedule.keySet();
		boolean[] recursionbooleanArray=new boolean[numCourses];
		boolean[] visitedbooleanArray=new boolean[numCourses];
		
		for(int temp:sourceSet) {
			if(visitedbooleanArray[temp])continue;
			if(!isCourseSchedulePossible(temp,recursionbooleanArray,visitedbooleanArray,adjacencyListRepCourseSchedule))
			{
			  return false;	
			}
			recursionbooleanArray[temp]=false;
		}
     
		return true;
    }
	
	public static boolean isCourseSchedulePossible(int source,boolean[] recursionbooleanArray, boolean[] visitedbooleanArray,Map<Integer,List<Integer>> neighboursMap) {
		recursionbooleanArray[source]=true;
		visitedbooleanArray[source]=true;
		List<Integer> neighboursoftheSource=neighboursMap.get(source);
		for(int temp:neighboursoftheSource) {
			if(recursionbooleanArray[temp])return false;
			else
				//go into dfs
			{	
				return isCourseSchedulePossible(temp, visitedbooleanArray,recursionbooleanArray, neighboursMap);
			}
			
		}	
		recursionbooleanArray[source]=false;
		return true;
	}

	/**
	 * 
	 * Time Complexity-O(V+E)-->since in the while loop all the edges and vertices are iterated though
	 */
	public static boolean isCourseSchedulePossibleBFStopological(int[][] prerequisites,int numCourses) {
		
		int[] indegreeCounter=new int[numCourses];
		Queue<Integer> queue=new LinkedList<>();
		int noOfEdges=prerequisites.length;
		int countofTopologicalSotedVertices=0;
		//use a adjacency list representation for the graph to get the edges
				Map<Integer,List<Integer>> adjacencyListRepCourseSchedule=new HashMap<>();
				for(int i=0;i<numCourses;i++) {
					adjacencyListRepCourseSchedule.put(i, new ArrayList<Integer>());
				}
				//iterate though the prerequisites array and add the edges to the adjacency list representation
				//prerequisites.length gives the number of array having [source,destination] format
				for(int i=0;i<noOfEdges;i++) {
					ArrayList<Integer> al = (ArrayList<Integer>) adjacencyListRepCourseSchedule.get(prerequisites[i][1]);
					 al.add(prerequisites[i][0]);
					 //count the indegree for the end vertex
					 indegreeCounter[prerequisites[i][0]]++;
					adjacencyListRepCourseSchedule.put(prerequisites[i][1],al);
				}

				for(int i=0;i<indegreeCounter.length;i++) {
					if(indegreeCounter[i]==0) {
						queue.add(i);
						countofTopologicalSotedVertices++;
					}
				}
		while(!queue.isEmpty()) {
				int course=(int)queue.poll();
				List<Integer> outgoingEdges=adjacencyListRepCourseSchedule.get(course);
				for(int i=0;i<outgoingEdges.size();i++) {
					indegreeCounter[outgoingEdges.get(i)]--;
					if(indegreeCounter[outgoingEdges.get(i)]==0) {
						queue.add(outgoingEdges.get(i));
						countofTopologicalSotedVertices++;
					}
				}
			
		}
		if(countofTopologicalSotedVertices==numCourses)
			return true;
		else 
			return false;
	}
}
