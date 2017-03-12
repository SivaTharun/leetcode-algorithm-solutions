package com.arrays.practice;

public class RemoveElement {

	public static void main(String[] args) {
		
		int[] input ={1 ,2 ,3 ,4 ,5 ,3 ,6 ,7};
		int element = 3;
		System.out.println(removeElementLinearTime(input, element));
		
	}
	
	//two point technique
	//traversing the array from back and pushing the rest elements into the place of desired element.
	//time complexity-O(n)
	static int removeElement(int[] input,int element) {
		int inputLength = input.length;
		for (int j= inputLength-1;j>=0;j--) {
			if(element==input[j]) {
				for(int i=j+1;i<inputLength;i++) {
					input[i-1]=input[i];
				}
				inputLength--;
			}
		}
		
		return inputLength;
	}
	
	//time complexity-O(n)
	static int removeElementLinearTime(int[] input,int element) {
		int i=0;
		int j=0;
		int n = input.length;
		while(i<n) {
			if(input[i]!=element) {
				input[j++]=input[i];
			}
			i++;
		}
		return j;
	}

}
