
/*
 * 
 * Given a number n, find the highest power of 2 that is smaller than or equal to n.
 */
import java.util.*;

public class TwoPowerLessThanNumber 
{
	
	 static int highestPowerof2(int n) 
	 { 
	     int res = 0;
	     if(n<2) return res;
	     
	     for (int i = 0; i < 32; i++) 
	     { 
	    	//try every 2th power
	    	 int curr= 1<<i; 
	    	 
	    	 if(curr> n) break;
	    	 
	    	 res=curr;
	    	 
	     } 
	     return res; 
	   } 

	public static void main(String[] args) {
		int n = 17; 
	     System.out.println(highestPowerof2(n)); 

	}

}
