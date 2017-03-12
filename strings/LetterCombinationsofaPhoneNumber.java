package com.strings.practice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 17. Letter Combinations of a Phone Number 
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 */
public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

		String digits ="23";
		ArrayList<String> output = getPossibleCombinationsForTheInput(digits);
		for(String result:output) {
			System.out.println(result);
		}
	}
	
	/**
	 * This a combination problem asking to get the all the possible combinations for the letters.use the recursion(DFS) technique to solve this
	 * 
	 * 
	 */
	static ArrayList<String> getPossibleCombinationsForTheInput(String digits) {
		
		HashMap<Integer, String> phoneMap = getPhoneMap();
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		
		combinationHelper(temp, result, digits,phoneMap);
		
		return result;
	}
	
	/**
	 * Time Complexty-O()
	 * @param temp
	 * @param result
	 * @param digits
	 * @param phoneMap
	 */
	static void combinationHelper(ArrayList<String> temp,ArrayList<String> result,String digits,HashMap<Integer, String> phoneMap) {
		if(digits.length()==0) {
		char[] arr = new char[temp.size()];
	       for(int i=0; i<temp.size(); i++){
	            arr[i] = temp.get(i).charAt(0);
	        }
			result.add(String.valueOf(arr));
			return;
		}
		
		int curr=Integer.valueOf(digits.substring(0,1));
		String currString = phoneMap.get(curr);
		
		for(int i=0;i<currString.length();i++) {
			temp.add(String.valueOf(currString.charAt(i)));
			combinationHelper(temp, result, digits.substring(1), phoneMap);
			//remove the combination in which temp contains [a,a,b,b,c,c] all the letters are the same.
			temp.remove(temp.size()-1);
		}
		
	}
	
	static HashMap<Integer, String> getPhoneMap() {
		
		HashMap<Integer, String> phoneMap = new HashMap<>();
		phoneMap.put(2, "abc");
		phoneMap.put(3, "def");
		phoneMap.put(4, "ghi");
		phoneMap.put(5, "jkl");
		phoneMap.put(6, "mno");
		phoneMap.put(7, "pqrs");
		phoneMap.put(8, "tuv");
		phoneMap.put(9, "wxyz");
		phoneMap.put(0, "");
		
		return phoneMap;
	}

}
