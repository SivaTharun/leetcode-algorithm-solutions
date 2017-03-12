package com.math.practice;

/**
 * 263. Ugly Number
 * Write a program to check whether a given number is an ugly number.
 * @author SivaTharun
 *
 */
public class UglyNumber {

	public static void main(String[] args) {
		int number =7;
		System.out.println(isUglyNumberGreedySolution(number));

	}
	
	//rescursive solution
	//continuesly check whther the number is divided by 2/3/5
	//space complexity-O(n)
	//time complexity-O(logn)
	static boolean isUglyNumber(int number) {
		if(number==0) return false;
		if(number==1) return true;
		if(number%2==0) 
			return isUglyNumber(number/2);
		if(number%3==0)
			return isUglyNumber(number/3);
		if(number%5==0)
			return isUglyNumber(number/5);
		
		return false;
	}
	
	//greedy algorithm solution
	//
	static boolean isUglyNumberGreedySolution(int number) {
		if(number<=0) 
			return false;
		while(number>1&&number%2==0) {
			number=number/2;
		}
		while(number>1&&number%3==0) {
			number=number/3;
		}
		while(number>1&&number%5==0) {
			number=number/5;
		}
		if(number==1)return true;
		else {
			return false;
		}
	}


}
