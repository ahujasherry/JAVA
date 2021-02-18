package com.sherry.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Job
{
	int start;
	int finish;
	int profit;
	
	public Job(int s,int f,int p)
	{
		start=s;
		finish=f;
		profit=p;
	}
	public String toString()
	{
		return this.start+","+this.finish+","+this.profit;
	}
}

//ascending order according to finish time
class Compare implements Comparator<Job>
{

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		return o1.finish-o2.finish;
	}
	
}

public class JobSchedulingWithProfit {

	
	public static int maxProfit(ArrayList<Job> arr,int n)
	{
		int max_Profit=Integer.MIN_VALUE;
		Collections.sort(arr, new Compare());
		
		
		System.out.println(arr);
		max_Profit=maxProfitUtilDP(arr,n);
		
		return max_Profit;
	}
	//recursion
	public static int maxProfitUtil(ArrayList<Job> arr,int n)
	{
		if(n==1) return arr.get(0).profit;
		
		//take prev profit
		int exludeProfit=maxProfitUtil(arr, n-1);
		
		//find first non overlapping index
		int includeIndex=latestNonConflict(arr,n);
		
		int includeProfit=0;
		//include item and take profit untill includeIndex
		if(includeIndex!=-1)
			 includeProfit= arr.get(n-1).profit+ maxProfitUtil(arr, includeIndex+1);
		
		return Math.max(exludeProfit, includeProfit);
		
	}
	
	
	//DP
	public static int maxProfitUtilDP(ArrayList<Job> arr,int n)
	{
		//dp[i] means max profit untill that index
		int dp[]=new int[n];
		dp[0]=arr.get(0).profit;
	
		for(int i=1;i<n;i++)
		{
			//take prev profit
			int exclude=dp[i-1];

			//find first non overlapping index
			int includeIndex=latestNonConflict(arr, i);
			int include=0;
			

			if(includeIndex!=-1)
				 include= arr.get(i).profit+ dp[includeIndex];
			dp[i]=Math.max(include, exclude);
			
		}
		
		
		return dp[n-1];
		
	}
	
	public static int latestNonConflict(ArrayList<Job> arr,int index)
	{
		int low=0;
		int high= index--; //make the index level
		 while (low <= high) 
	        { 
	            int mid = (low + high) / 2; 
	            if (arr.get(index).start >= arr.get(mid).finish) 
	            { 
	                if (arr.get(index).start >= arr.get(mid+1).finish ) 
	                    low = mid + 1; 
	                else
	                    return mid; 
	            } 
	            else
	                high = mid - 1; 
	        } 
		return -1;
		
	}
	
	
	public static void main(String[] args) 
	{
		ArrayList<Job> arr=new ArrayList<>();
		arr.add(new Job(3,5,20));
		arr.add(new Job(1, 2, 50));
		arr.add(new Job(6, 19, 100));
		arr.add(new Job(2, 100, 200));
		
		System.out.println(maxProfit(arr,arr.size()));
		
	}

}
