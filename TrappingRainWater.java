/*
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 */

import java.util.*;
public class TrappingRainWater 
{
	
	//time complexity=O(n), space complexity=O(1)
	public static int maxWaterTwoPointers(int arr[], int n)
	{
		
		//if 0 or only 1 element, no water can be stored
		if(arr.length==0 ||arr.length==1  )  return 0;
		
		//final result
		int res=0;
		
		//maximum left and right till now
		int left_max=0,right_max=0;
		
		//two pointers, start and end
		int low=0,high=n-1;
		
		while(low<=high)
		{
			//left wall is shorter than right wall -> limiting cases on left
			if(arr[low] < arr[high])
			{
	
				if(arr[low] > left_max) left_max =arr[low];
				else res+= left_max - arr[low];
				low++;
			}
			//right wall is shorter than left wall -> limiting cases on right
			else
			{

				if(arr[high] > right_max) right_max=arr[high];
				else res+= right_max - arr[high];
			
				high--;
			}
		
		}
		
		
		return res; 
	}
	
	//time complexity=O(n), space complexity=O(n)
	public static int maxWater(int arr[], int n)
	{
		int res=0;
		
		//left and right array contains left max and right max includig that ith element -> pre computed 
		int left[] = new int[n]; 
		int right[] = new int[n]; 
		
		//populate left array
		left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
            left[i] = Math.max(left[i - 1], arr[i]);
        
        //populate right array
        right[n - 1] = arr[n - 1]; 
        for (int i = n - 2; i >= 0; i--) 
            right[i] = Math.max(right[i + 1], arr[i]); 
        
        //find height of water stored for each index
        for (int i = 0; i < n; i++) 
            res += Math.min(left[i], right[i]) - arr[i]; 
		
		
		return res; 
	}
	
	
	public static void main(String[] args) {
		 int[] arr = { 0, 1, 0, 2, 1, 0,  
                 1, 3, 2, 1, 2, 1 }; 
		 int n = arr.length; 
 
		 System.out.print(maxWater(arr,n)); 
	}

}






















