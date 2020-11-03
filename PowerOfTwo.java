/*
 * 
 * 
 *  if a number n is a power of 2 then bitwise & of n and n-1 will be zero.
 *  if n=0, return false
 */

import java.util.*;
class PowerOfTwo
{
    static boolean isPowerOfTwo (int x)
    {
        return x!=0 && ((x&(x-1)) == 0);
         
    }
     
    public static void main(String[] args) 
    {
         System.out.println(isPowerOfTwo(31) ? "Yes" : "No");
         
    }
}