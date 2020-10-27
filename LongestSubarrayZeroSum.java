import java.util.HashMap;

/*
 * 
 * Given an array of integers, find the length of the longest sub-array with sum equals to 0.
 * 
 *	Solution O(n) time: 3 cases
 *	1. Empty input-> length =0
 *	2. if cumilative sum=0 anywhere-> len= current index+1
 *	3. if same cumilative sum repeats-> len= current index- Prev_index 
 */
public class LongestSubarrayZeroSum {

	public static int maxLen(int arr[],int n)
	{
		boolean isEmpty=arr.length==0? true:false;
		boolean firstEle=(arr.length==1 && arr[0]==0)?true:false;
		if(firstEle) return 1;
		if(isEmpty) return 0;
		
		
		int global_ans=0,len=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int sum=0;
		for (int i = 0; i < arr.length; i++) 
		{	
			sum+=arr[i];
			
			//2nd case
			if(sum==0)
			{
				len= i+1;
			}
			else
			{
				if(map.containsKey(sum))
				{
					//3rd case
					len=i-map.get(sum);
				}
				else
				{
					map.put(sum, i);
					
				}
			}
			global_ans=Math.max(global_ans, len);
		}
		
		return global_ans;
	}
	public static void main(String[] args) 
	{
		int arr[] = {15,-2,2,-8,1,7,10,23}; 
        int n = arr.length; 
        System.out.println("Length " + maxLen(arr, n)); 
	}

}
