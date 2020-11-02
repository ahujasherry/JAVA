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
		
		
		return res; 
	}
	
	
	public static void main(String[] args) {
		 int[] arr = { 0, 1, 0, 2, 1, 0,  
                 1, 3, 2, 1, 2, 1 }; 
		 int n = arr.length; 
 
		 System.out.print(maxWaterTwoPointers(arr,n)); 
	}

}
