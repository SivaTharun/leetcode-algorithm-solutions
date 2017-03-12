package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
   
 * @author SivaTharun
 *
 */
public class SubsetsII {

 
	public static void main(String[] args) {
		//the set conatins duplicate elements
		int input[] = new int[]{1,2,2};
		List<List<Integer>> al = getSubSetWithDuplicatesIterative(input);
		System.out.println(al);
	}
	
	static List<List<Integer>> getSubsetListWithDuplicateInput(int[] input) {
		List<List<Integer>> al = new ArrayList<>();
		//adding the empty array list at the beginning
		al.add(new ArrayList<Integer>());
		//sort the input array
		Arrays.sort(input);
		List<Integer> currList = new ArrayList<>();
		helper(al, 0, input,currList);
		return al;
	}
	
	/**
	 * Backtracking solution
	 * Time Complexity-O(2^n)-->exponential
	 * Space Complexity-O(n)
	 */
	static void helper(List<List<Integer>> result,int index,int[] input,List<Integer> currList) {
		for(int k=index;k<input.length;k++) {
			//add the curr element to the result list
			currList.add(input[k]);
			result.add(new ArrayList<>(currList));
			helper(result, k+1, input, currList);
			//remove the last element in the current list to keep the max size of curr list to input[] length else it would have size > length of input[].
			currList.remove(currList.size()-1);
			//check for if the current elements has any duplicated,skip that element if any duplicate is found
			while(k<input.length-1&&input[k]==input[k+1]) {
				k++;
			}
		}
		
	}
	
	/**
	 * Time Complexity-O(m*n)
	 * m-size of input array
	 * n-size of result list
	 * size complexity-O(n)
	 * @param input
	 * @return
	 */
	static List<List<Integer>> getSubSetWithDuplicatesIterative(int[] input) {
		List<List<Integer>> resultSet = new ArrayList<>();
		//add the empty array list
		resultSet.add(new ArrayList<Integer>());
		for(int currentnum: input) {
			int size=resultSet.size();
			for(int i=0;i<size;i++) {
				List<Integer> current = new ArrayList<>(resultSet.get(i));
				current.add(currentnum);
				if(current.equals(resultSet.get(size-1))) {
					continue;
				}
				resultSet.add(current);
			}
		}
		
		return resultSet;
	}
	
	/*static List<List<Integer>> getSUbsetList(int[] input) {
		int n= input.length;
		
		List<Integer> temp=new ArrayList<>();
		for(int i=0;i<n;i++) {
			temp.add(input[i]);
			constructSubSets(temp,input,i);
			al.add(temp);
			temp.remove(temp.size()-1);
		}
		return al;
	}
	
	static void constructSubSets(List<Integer> input,int[] inputArray,int index) {
		
		for(int i=0;i<inputArray.length;i++) {
			if(input.size()<=3&&i!=index) {
			input.add(inputArray[i]);
			constructSubSets(input, inputArray,i);
			} else 
				return;
		}
		
	}*/

}
