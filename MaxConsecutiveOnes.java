
/*
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
import java.util.*;

public class MaxConsecutiveOnes {

	//smart solution
	public static int findMaxConsecutiveOnes1(int[] arr) 
    {
        if(arr.length ==0 ) return 0;
        if(arr.length ==1 && arr[0]==1) return 1;
        
        int sum=0;
        int res=0;
        
        for(int ele:arr)
        {
        	//sum=1 show prev ele was 1, its consecutive
            sum*=ele;
            
            //act as count
            sum+=ele;
            res=Math.max(sum,res);
            
        }
        
        return res;
        
    }
	public static int findMaxConsecutiveOnes(int[] arr) 
    {
        if(arr.length ==0 ) return 0;
        if(arr.length ==1 && arr[0]==1) return 1;
        int res=0;
        int count=0;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                count++;
            }else
            {
                count=0;
            }
            
            res=Math.max(count,res);
            
        }
        
        return res;
        
    }
	public static void main(String[] args) 
	{
		 int arr[] = {1,0,1,1,0,1,1,1}; 
               
		 int n = arr.length; 
  
		 System.out.println(findMaxConsecutiveOnes1(arr)); 

	}

}
