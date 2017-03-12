package com.strings.practice;

/**
 * 423. Reconstruct Original Digits from English
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

	Note:

    Input contains only lowercase English letters.
    Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
    Input length is less than 50,000.

 * @author SivaTharun
 *
 */
public class ReconstructOriginalDigitsfromEnglish {

	public static void main(String[] args) {
		String input ="fveithrourfee";
		System.out.println(getOriginalDigits(input));
		
	}
	
	
	/**
	 *  For all numbers from 0 - 9, there are certain characters that only exists once in the numbers' english expressions:

		z: zero 0
		w: two 2
		u: four 4
		x: six 6
		g: eight 8

		which means from the occurrence of the above five characters, we can find 5 numbers. Now let's take a look of the rest:

		o: zero 0, one 1, two 2, four 4

		since we already know number of 0, 2, 4, we can calculate number of 1s by nums[1] = counts['o'] - nums[0] - nums[2] - nums[4], similarly, we can find all following numbers:

		h: three 3, eight 8
		f: four 4, five 5
		s: six 6, seven 7
		i: five 5, six 6, eight 8, nine 
		Time Complexity-O(n)
		space complexity-O(n) 
	 * @param input
	 * @return
	 */
	static String getOriginalDigits(String input) {
		
		int[] count = new int[26];
		//UTF-16 code for 'a' is 36.
		for(int i=0;i<input.length();i++) {
			count[input.charAt(i)-'a']++;
		}
		//stores the count for the respective numbers by taking it from
		//the character count array.
		int[] numcount = new int[10];
		numcount[0]=count['z'-'a'];
		numcount[2]=count['w'-'a'];
		numcount[6]=count['x'-'a'];
		numcount[4]=count['u'-'a'];
		numcount[8]=count['g'-'a'];
		numcount[1]=count['o'-'a']-numcount[0]-numcount[2]-numcount[4];//1->0-2-4
		numcount[3]=count['h'-'a']-numcount[8];//3->h-8
		numcount[5]=count['f'-'a']-numcount[4];//5->f-4
		numcount[7]=count['s'-'a']-numcount[6];//7->s-6
		numcount[9]=count['i'-'a']-numcount[5]-numcount[6]-numcount[8];//9->i-5-6
		
		String str="";
		for(int i=0;i<10;i++) {
			for(int j=0;j<numcount[i];j++) {
				str+=i;
			}
		}
		return str;
	}
	}
