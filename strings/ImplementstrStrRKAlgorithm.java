package com.strings.practice;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 * 28.Implement strStr().
 * The average and best case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm). Worst case of Rabin-Karp algorithm occurs when all characters of pattern and text are same as the hash values of all the substrings of txt[] match with hash value of pat[]. For example pat[] = “AAA” and txt[] = “AAAAAAA”.
 * @author SivaTharun
 *
 */
public class ImplementstrStrRKAlgorithm {

    /** String Pattern **/

    private String pat; 

    /** pattern hash value **/    

    private long patHash;    

    /** pattern length **/

    private int M;  

    /** Large prime **/         

    private long Q; 

    /** radix **/         

    private int R;   

    /** R^(M-1) % Q **/
    //mod function to avoid hashing collision for different patterns

    private long RM;          

 

    /** Constructor **/

    public ImplementstrStrRKAlgorithm(String txt, String pat) 

    {

        this.pat = pat;      
        
        //convert binary to integer
        R = 256;

        M = pat.length();
        
        //random prime number
        Q = longRandomPrime();

        /** precompute R^(M-1) % Q for use in removing leading digit **/

        RM = 1;

        for (int i = 1; i <= M-1; i++)

           RM = (R * RM) % Q;

        patHash = hash(pat, M);

        int pos = search(txt);

        if (pos == -1)

            System.out.println("\nNo Match\n");

        else

            System.out.println("Pattern found at position : "+ pos);

    } 

    /** Compute hash for the pattern**/

    private long hash(String key, int M)

    { 

        long h = 0; 

        for (int j = 0; j < M; j++) 

            h = (R * h + key.charAt(j)) % Q; 

        return h; 

    } 

    /** Funtion check if the corresponding hash functions of pattern and haystack are matching**/

    private boolean check(String txt, int i) 

    {

        for (int j = 0; j < M; j++) {

            if (pat.charAt(j) != txt.charAt(i + j)) 

                return false; 
        }

        return true;

    }

    /** Funtion to check for exact match**/

    private int search(String txt) 

    {

        int N = txt.length(); 

        if (N < M) return N;

        long txtHash = hash(txt, M); 

        /** check for match at start **/

        if ((patHash == txtHash) && check(txt, 0))

            return 0;

        /** check for hash match. if hash match then check for exact match**/

        for (int i = M; i < N; i++) 

        {
        	//rolling hash function calculation
            // Remove leading digit, add trailing digit, check for match.
        	
        	/**
        	 * Hash(H1) over k characters(c1..ck) could be computed as follows:
			H1= c1*a^k-1 + c2*a^k-2+c3*a^k-3+…+ck*a^0
			where a is a constant
			and c1…ck are input characters.

			Lets assume you want to calculate the hash(H2) over same size window k over characters(c2..ck+1) could be computed from similar logic above as follows:
			H2 = c2*a^k-1+c3*a^k-2+…+ck+1*a^0
			where a is a constant
			and c2..ck+1 are input characters.

			Now, if we look carefully, H2 = [H1*a] + [ck+1*a^0(i.e. last term of this window)] - [c1*a^k-1(i.e. first term of H1)]
        	 */
        	
        	//remove the fisrt index hash fucntion from the existing hash function.
            txtHash = (txtHash + (Q - RM) * txt.charAt(i - M) % Q) % Q; 
            
            //add the hash  character at index 'i'
            txtHash = (txtHash * R + txt.charAt(i)) % Q; 

            // match

            int offset = i - M + 1;

            if ((patHash == txtHash) && check(txt, offset))

                return offset;

        }

        /** no match **/

        return -1;

    }

    /** generate a random 31 bit prime **/

    private static long longRandomPrime() 

    {
 
        BigInteger prime = BigInteger.probablePrime(31, new Random());

        return prime.longValue();

    }

    /** Main Function **/

    public static void main(String[] args) throws IOException

    {    
        String text ="findaneedleinahaystack";
        String pattern="needle";
        		
        ImplementstrStrRKAlgorithm rk = new ImplementstrStrRKAlgorithm(text, pattern);    
        

    }
}
