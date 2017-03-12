package com.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1,2,3};
		System.out.println(getSubListWithOutDupIterative(input));
	}
	
	static List<List<Integer>> getSubListWithOutDuplicates(int[] input) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		List<Integer> current = new ArrayList<>();
		Arrays.sort(input);
		helper(input, 0, current, result);
		return result;
	}
	
	/**
	 * Time Complexity-O(2^n)
	 * Space Complexity-O(n)
	 * @param input
	 * @param index
	 * @param current
	 * @param result
	 */
	static void helper(int[] input,int index,List<Integer> current,List<List<Integer>> result) {
		
		for(int j=index;j<input.length;j++) {
			current.add(input[j]);
			result.add(new ArrayList<>(current));
			helper(input, j+1, current, result);
			//to restrict the current array size to max value of input i.e 3 here in this case
			current.remove(current.size()-1);
		}
	}
	
	/**
	 * Time Complexity-O(m*n)
	 * m-size of input array 
	 * n-size of result list
	 * @param input
	 * @return
	 */
	static List<List<Integer>> getSubListWithOutDupIterative(int[] input) {
		
		List<List<Integer>> resultSet = new  ArrayList<>();
		resultSet.add(new ArrayList<>());
		for(int num:input) {
			int size = resultSet.size();
			for(int i=0;i<size;i++) {
				List<Integer> current = new ArrayList<>(resultSet.get(i));
				current.add(num);
				resultSet.add(current);
			}
			
		}
		return resultSet;
	}
}
