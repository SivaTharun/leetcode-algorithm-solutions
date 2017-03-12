package com.strings.practice;

import java.util.ArrayList;

public class ImplementstrStrKMPAlgorithm {

	public static void main(String[] args) {
		
		String text="AAAAABAAABA";
		String pattern = "ABCDABCA";
		System.out.println(getNeedleInHayStackPositions(pattern, text));
	}
	
	/**
     *
     *Matching Overview
		txt = "AAAAABAAABA" 
		pat = "AAAA"

		We compare first window of txt with pat
		txt = "AAAAABAAABA" 
		pat = "AAAA"  [Initial position]
		We find a match. This is same as Naive String Matching.

		In the next step, we compare next window of txt with pat.
		txt = "AAAAABAAABA" 
		pat =  "AAAA" [Pattern shifted one position]
		This is where KMP does optimization over Naive. In this 
		second window, we only compare fourth A of pattern
		with fourth character of current window of text to decide 
		whether current window matches or not. Since we know 
		first three characters will anyway match, we skipped 
		matching first three characters.
		Need of Preprocessing?
An important question arises from above explanation, 
how to know how many characters to be skipped. To know 
this, we pre-process pattern and prepare an integer array 
lps[] that tells us count of characters to be skipped. 

Preprocessing Overview:

    KMP algorithm does preproceses pat[] and constructs an auxiliary lps[] of size m (same as size of pattern) which is used to skip characters while matching.
    name lps indicates longest proper prefix which is also suffix.. A proper prefix is prefix with whole string not allowed. For example, prefixes of “ABC” are “”, “A”, “AB” and “ABC”. Proper prefixes are “”, “A” and “AB”. Suffixes of the string are “”, “C”, “BC” and “ABC”.
    For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].

       lps[i] = the longest proper prefix of pat[0..i] 
                  which is also a suffix of pat[0..i]. 

 	
 	Note : lps[i] could also be defined as longest prefix which is also proper suffix. We need to use proper at one place to make sure that the whole substring is not considered.

Examples of lps[] construction:
For the pattern “AAAA”, 
lps[] is [0, 1, 2, 3]

For the pattern “ABCDE”, 
lps[] is [0, 0, 0, 0, 0]

For the pattern “AABAACAABAA”, 
lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]

For the pattern “AAACAAAAAC”, 
lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4] 

For the pattern “AAABAAA”, 
lps[] is [0, 1, 2, 0, 1, 2, 3]

Searching Algorithm:
Unlike Naive algorithm, where we slide the pattern by one and compare all characters at each shift, we use a value from lps[] to decide the next characters to be matched. The idea is to not match character that we know will anyway match.

How to use lps[] to decide next positions (or to know number of characters to be skipped)?

    We start comparison of pat[j] with j = 0 with characters of current window of text.
    We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] keep matching.
    When we see a mismatch
        We know that characters pat[0..j-1] match with txt[i-j+1…i-1] (Note that j starts with 0 and increment it only when there is a match).
        We also know (from above definition) that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
        From above two points, we can conclude that we do not need to match these lps[j-1] characters with txt[i-j…i-1] because we know that these characters will anyway match. Let us consider above example to understand this.

txt[] = "AAAAABAAABA" 
pat[] = "AAAA"
lps[] = {0, 1, 2, 3} 

i = 0, j = 0
txt[] = "AAAAABAAABA" 
pat[] = "AAAA"
txt[i] and pat[j[ match, do i++, j++

i = 1, j = 1
txt[] = "AAAAABAAABA" 
pat[] = "AAAA"
txt[i] and pat[j[ match, do i++, j++

i = 2, j = 2
txt[] = "AAAAABAAABA" 
pat[] = "AAAA"
pat[i] and pat[j[ match, do i++, j++

i = 3, j = 3
txt[] = "AAAAABAAABA" 
pat[] = "AAAA"
txt[i] and pat[j[ match, do i++, j++

i = 4, j = 4
Since j == M, print pattern found and resset j,
j = lps[j-1] = lps[3] = 3

Here unlike Naive algorithm, we do not match first three 
characters of this window. Value of lps[j-1] (in above 
step) gave us index of next character to match.
i = 4, j = 3
txt[] = "AAAAABAAABA" 
pat[] =  "AAAA"
txt[i] and pat[j[ match, do i++, j++

i = 5, j = 4
Since j == M, print pattern found and reset j,
j = lps[j-1] = lps[3] = 3

Again unlike Naive algorithm, we do not match first three 
characters of this window. Value of lps[j-1] (in above 
step) gave us index of next character to match.
i = 5, j = 3
txt[] = "AAAAABAAABA" 
pat[] =   "AAAA"
txt[i] and pat[j] do NOT match and j > 0, change only j
j = lps[j-1] = lps[2] = 2

i = 5, j = 2
txt[] = "AAAAABAAABA" 
pat[] =    "AAAA"
txt[i] and pat[j] do NOT match and j > 0, change only j
j = lps[j-1] = lps[1] = 1 

i = 5, j = 1
txt[] = "AAAAABAAABA" 
pat[] =     "AAAA"
txt[i] and pat[j] do NOT match and j > 0, change only j
j = lps[j-1] = lps[0] = 0

i = 5, j = 0
txt[] = "AAAAABAAABA" 
pat[] =      "AAAA"
txt[i] and pat[j] do NOT match and j is 0, we do i++.

i = 6, j = 0
txt[] = "AAAAABAAABA" 
pat[] =       "AAAA"
txt[i] and pat[j] match, do i++ and j++

i = 7, j = 1
txt[] = "AAAAABAAABA" 
pat[] =       "AAAA"
txt[i] and pat[j] match, do i++ and j++

We continue this way...
     *
     * Space Complexity-O(N)
     * Time Complexity(M+N)
     * where O(N) is the time taken to build the auxillary array.
     * Worst case when pattern is like AABA and text is like AABAAABA.,here we have to search each charcter of text with that of pattern.
	 * 
	 * 
	 */
	static ArrayList<Integer> getNeedleInHayStackPositions(String pattern,String text) {
		
		int[] aux=new int[pattern.length()];
		int M=pattern.length();
		int N=text.length();
		ArrayList<Integer> al = new ArrayList<>();
		int i=0;
		int j=0;
		constructAuxillaryArrayForMatching(aux, pattern);
		while(i<N) {
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;j++;
				//if the index of j is equal to pattern length then pattern is found and add the index of pattern found to array list
				if(j==M) {
					//index of the pattern
					al.add(i-j);
					//reassign the value of j from the auxillary array.check whether there is a suffix which is also the prefix for the apttern at that point.
					j=aux[j-1];
				}
			}else {
				//if the first letter of pattern is mismatching with the text then increament the count for index of text leaving the index of pattern unchanged 
				if(j==0) {
					i++;
					//we have to compare the first index at pattern from the new ith value.
					//if j is not first letter then rest its value from auxillary array and compare that character with the current text character.
				}else if(j!=0) {
					//start from the common index where common prefix and suffix are matched.
					j=aux[j-1];
				}
			}
			
			
		}
		return al;
		
	}
	
	//construct auxillary array for the given pattern
	static void constructAuxillaryArrayForMatching(int[] aux,String pattern) {
		int i=1;
		int j=0;
		//initialize aux[0]=0;
		aux[0]=0;
		
		while(i<pattern.length()) {
			//if matching then increment j and assign it to auxillary array.
			if(pattern.charAt(i)==pattern.charAt(j)) {
				j++;
				aux[i]=j;
				i++;
			}else {
				//if not matching then reassign j as 0 and increament i.
				if(j!=0) {
					//modify the value of j
				j=aux[j-1];
				}else {
					//j=0.
					aux[i]=j;
					i++;
					
				}
			}
		}
		
		
	}

}
