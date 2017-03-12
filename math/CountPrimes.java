package com.math.practice;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * @author SivaTharun
 *
 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 11;
		System.out.println(seiveOfErosthosness(number));

	}
	
	//naive approach to count prime numbers
	//time complexity-O(n^2)
	static int countPrimes(int number) {
		int count =0;
		for (int i=2;i<=number;i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	
	 static boolean isPrime(int number) {
		 if(number==2) {
				return true;
			}
		for (int i=2;i<number;i++) {
			
			if(number%i==0)
				return false;
		}
		return true;
	}
	
	static boolean isPrimeSqrt (int number) {
		for (int i=2;i*i<number;i++) {
			if(number%i==0)return false;
		}
		return true;
	}
	 
	//method -2
	//time complexity-O(n^3/2)
	static int countPrimesSqrt(int number) {
		int count =0;
		for (int i=2;i<=number;i++) {
			if(isPrime(i))count++;
		}
		return count;
	}
	
	//method -3
	//seive of erosthoness
	//space complexity-O(n)
	//time complexity-O(nloglogn)
	static int seiveOfErosthosness(int number) {
		boolean[] countArray = new boolean[number];
		int numberount=0;
		for(int i=2;i<number;i++) {
			countArray[i]=true;
		}
		
		for (int i=2;i*i<number;i++) {
			if(countArray[i]) {
			//starting point of j is i*i since i is taken as sqrt function
			//condition of erosthosness
			for(int j=i*i;j<number;j+=i) {
				countArray[j]=false;
			}
			}
		}
		
		for(boolean current:countArray) {
			if(current)numberount++;
		}
		return numberount;
	}
}
