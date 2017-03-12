package com.arrays.practice;

/**
 * 189.Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
 * @author SivaTharun
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7};
		int k = 3;
		int[] result =rotateArrayReverseTechnique(a,k);
		for (int current : result) {
			System.out.println(current);
		}
	}

	//time complexity-O(n)
	//space complexity-O(n)
	static int[] rotateArray(int[] a,int k) {
		int n = a.length;
		int[] newArray = new int[n];
		for (int i=0;i<n;i++) {
			int newIndex = ((i+k))%n;
			newArray[newIndex] = a[i];
		}
		return newArray;
	}
	
	//time complexity-O(k*n)
	//space complexity-O(n)
	static int[] rotateArrayBubbleRotate(int[] a,int k) {
		//rotate the array using a technique similar to bubble sort
		for(int rotateOrder=0;rotateOrder<k;rotateOrder++) {
			for(int j=a.length-1;j>0;j--) {
				int temp =a[j-1];
				a[j-1]=a[j];
				a[j]=temp;
			}
		}
		return a;
	}
	
	//reversing the array technique by dividing it into two parts
	//time complexity-O(n)
	//space complexity-O(1)
	static int[] rotateArrayReverseTechnique(int[] a, int k) {
		reverse(a,a.length-k-1, 0);
		reverse(a,a.length-1,a.length-k);
		reverse(a,a.length-1,0);
		
		return a;
		
	}
	
	static void reverse(int[] a,int upperLimit,int lowerLimit) {
		
		while(lowerLimit<upperLimit) {
			int temp = a[lowerLimit];
			a[lowerLimit] = a[upperLimit];
			a[upperLimit]= temp;
			lowerLimit++;
			upperLimit--;
		}
	}
}
