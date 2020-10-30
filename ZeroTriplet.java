
/*
 * 
 * Find unique triplet in array which makes sum=0
 */
import java.util.*;

public class ZeroTriplet
{
	public void print(List<List<Integer>> arr)
	{
		for (int i = 0; i < arr.size(); i++) 
		{
			System.out.print(arr.get(i).toString()+" ");
			
		}
		
	}
	
	public void threeSum(int[] arr) 
    {
		//resultant list 
        List<List<Integer>> res_list=new LinkedList<>();
		
        //no triplet if array length <3
        if(arr.length <3 )return  ;
			
	    
        //time complexity of sorting = O(nlogn)
		Arrays.sort(arr);
		
        int n=arr.length;
        
        
        //fix every ith element and find 2sum using 2 pointer method
        for (int i = 0; i < n-2; i++) 
        {
            //when array elements values are positive, sum=0 is not possible with next elements
        	if(arr[i] >0 ) break;
            
        	//to skip the duplicates
        	if( (i==0) || ( i >0 && arr[i]!=arr[i-1]) )
        	{
        		int l=i+1, r=n-1;
        		while(l<r)
	        	{
        			if(arr[i]+arr[l]+arr[r]==0) 
        			{
        				res_list.add(Arrays.asList(arr[i],arr[l],arr[r]));
                        
        				//handle duplicates for l and r values with fixed i
        				while(l<r && arr[l]==arr[l+1]) l++;
                        while(l<r && arr[r]==arr[r-1]) r--;
                        l++;
                        r--;
        			}
        			else if(arr[i]+arr[l]+arr[r] > 0 ) r--;
        			else l++;
	        	}
        	}
        	
		}
	        	print(res_list)   ;     
        
    }
	   
	
	public static void main(String[] args) 
	{

		ZeroTriplet triplet = new ZeroTriplet();
        int array[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> res;
        triplet.threeSum(array);

	}

}
