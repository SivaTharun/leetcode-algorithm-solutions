package com.math.practice;

/**
 * 365. Water and Jug Problem
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

    Fill any of the jugs completely with water.
    Empty any of the jugs.
    Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

 * 
 *
 */
public class WaterandJugProblem {

	public static void main(String[] args) {

		int x=2;
		int y=6;
		int z=5;
		System.out.println(canMeasureWater(x, y, z));
	}
	
	/**
	 * 
       The basic idea is to use the property of Bézout's identity and check if z is a multiple of GCD(x, y)
       
    Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:

    let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
    and y such that ax+by=d

    In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by

    every integer of the form ax + by is a multiple of the greatest common divisor d.

	 * 
	 * If a or b is negative this means we are emptying a jug of x or y gallons respectively.

Similarly if a or b is positive this means we are filling a jug of x or y gallons respectively.

x = 4, y = 6, z = 8.

GCD(4, 6) = 2

8 is multiple of 2

so this input is valid and we have:

-1 * 4 + 6 * 2 = 8

In this case, there is a solution obtained by filling the 6 gallon jug twice and emptying the 4 gallon jug once. (Solution. Fill the 6 gallon jug and empty 4 gallons to the 4 gallon jug. Empty the 4 gallon jug. Now empty the remaining two gallons from the 6 gallon jug to the 4 gallon jug. Next refill the 6 gallon jug. This gives 8 gallons in the end)
	 * 
	 * Time Complexity-O(1)
	 * Space Complexity-O(1)
	 */
	static boolean canMeasureWater(int x,int y,int z) {
		
		if(z>x+y)return false;
		
		if(x+y==z || x==z ||y==z)
			return true;
		if(x<y)
			swap(x,y);
		
		return z%getGCD(x,y)==0;
	}

	public  static void swap(int x,int y){
		int temp=x;
		x=y;
		y=temp;
	}
	
	//to get the gcd of x,y where x>y
	static int getGCD(int x,int y) {
		
		while(y!=0) {
			
			int temp=y;
			//check for the vale of y when x%y
			y=x%y;
			x=temp;
		}
		return x;
	}
}
