package com.math.practice;

public class IntegerBreak {

	public static void main(String[] args) {
		int input =9;
		System.out.println(getMaxIntegerBreak(input));
	}

	//dp solution
	//Time Complexity-O(n)
	//space Complexity-O(1)
	static int getMaxIntegerBreak(int input) {
		
		int[] dpProduct = new int[input+1];
		dpProduct[0]=0;//for 0 the product is 0
		dpProduct[1] = 1;//1 =0+1 ,max product is 1.
		
		for(int i=2;i<=input;i++) {
			//input=k+i;
			for(int k=1;k<i;k++) {
				dpProduct[i]=Math.max(dpProduct[i],Math.max(k*(i-k),dpProduct[k]*(i-k)));
			}
		}
		return dpProduct[input];
		
	}
	
	/**
	 * If an optimal product contains a factor f >= 4, 
	 * then you can replace it with factors 2 and f-2 without losing optimality, 
	 * as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, 
	 * meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and you'd only use it for n=2 and n=3, where it's needed).
	 * For n=3
	 * 3*3 is simply better than 2*2*2, so you'd never use 2 more than twice.
	 * so we use 3 as the dividing input.
	 * What is the max product if we break a number N into two factors?

I use a function to express this product: f=x(N-x)

When x=N/2, we get the maximum of this function.

However, factors should be integers. Thus the maximum is (N/2)*(N/2) when N is even or (N-1)/2 *(N+1)/2 when N is odd.

When the maximum of f is larger than N, we should do the break.

(N/2)*(N/2)>=N, then N>=4

(N-1)/2 *(N+1)/2>=N, then N>=5

These two expressions mean that factors should be less than 4, otherwise we can do the break and get a better product. The factors in last result should be 1, 2 or 3. Obviously, 1 should be abandoned. Thus, the factors of the perfect product should be 2 or 3.

The reason why we should use 3 as many as possible is

For 6, 3 * 3>2 * 2 * 2. Thus, the optimal product should contain no more than three 2.
	 * 
	 */
	static int getMaxIntegerbreak(int input){
		if(input==2||input==3)
			return input-1;
		else if(input==4)
			return 4;
		int product=1;
		while(input>4) {
			product=product*3;
			input=input-3;
		}
		//multiply the remaining input with the product.
		product=product*input;
		return product;
	}
	
}
