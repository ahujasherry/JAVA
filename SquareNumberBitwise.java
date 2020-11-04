/*
 * 
 * calculate square of number without using /,* and pow()
 * 
 * 1. using repeated addition -> T.C = O(n)
 * 
 * 2. Bitwise -> T.C = O(logn)
 */

import java.util.*;
public class SquareNumberBitwise {
	
	static int square(int n)
    {
		//base case
		if(n==0) return 0;
		
		//handle negative numbers
		if(n<0) n=-n;
		
		
		//divide by 2 for next iteration
		int x=n>>1;
       
    
		//if even sq(n) -> 4*x2
		if( n%2 ==0) return square(x)<<2;
		
		//odd case -> sq(n) -> 4*x2+ 4*x +1
		else return ( (square(x)<<2) + (x<<2) +1);
    }

	public static void main(String[] args) 
	{
		for (int n = 1; n <= 5; n++)
            System.out.println("n = " + n
                               + " n^2 = " + square(n));
	
	}

}
