/*
 * 
 * In Java we need to put attention on the fact that the maximum integer is 2147483647. 
 * Integer type in Java is signed and there is no unsigned int. 
 * So the input 2147483648 is represented in Java as -2147483648 (in java int type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
 * This force us to use n!=0 in the while condition and we cannot use n>0
 * because the input 2147483648 would correspond to -2147483648 in java and the code would not enter 
 * the while if the condition is n>0 for n=2147483648.
 */
import java.util.*; 
  
class SetBitsCount { 
  
	
	//naive method, right shift by 1 bit and count 
	//T.C -> O(logn)
	static int countSetBits1(int n) 
    { 
		if(n==0 ) return 0;
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
  
	//. Brian Kernighan’s Algorithm
	//T.C -> O(logn)
	static int countSetBits(int n) 
    { 
		if(n==0 ) return 0;
        int count = 0; 
        while (n > 0) 
        { 
            n &= (n - 1); 
            count++; 
        } 
        return count; 
    } 
  
    public static void main(String args[]) 
    { 
        int i = 9; 
        System.out.println(countSetBits(i)); 
    } 
} 
  