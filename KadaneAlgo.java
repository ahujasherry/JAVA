import java.util.Scanner;

/*\
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum 
 * and start and end .
 * 
 */

public class KadaneAlgo {

	int a[];
	public KadaneAlgo(int n)
	{
		a=new int[n];
	}
	
    public int maxSubArray(int[] a) 
    {
    	 int ans = Integer.MIN_VALUE; 
         int sum = 0; 
   
         for (int i = 0; i < a.length; i++) 
         { 
        	 
        	 sum = Math.max(a[i], sum+a[i]); 
           
             
             
             ans = Math.max(ans, sum); 
         } 
         
         return ans; 

    }
	public static void main(String[] args) 
	{
		System.out.println("enter size");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
	
		KadaneAlgo obj=new KadaneAlgo(n);
		System.out.println("enter array");
		for (int i = 0; i < n; i++) {
			obj.a[i]=sc.nextInt();
		}
		System.out.println(obj.maxSubArray(obj.a));
		
		

	}

}
