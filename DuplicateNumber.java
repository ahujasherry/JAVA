
/*
 * 
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times. Find these repeating numbers in O(n) 
 * there is atleast one duplicate present
 * 
 */

import java.util.ArrayList;
public class DuplicateNumber 
{
	private ArrayList<Integer> list;
	int a;
	
	public DuplicateNumber()
	{
		list=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			list.add(null);
		}
		
		a=0;
	}
	
	

	
	//1. Bit manipulation but overflow occurs. Because int is 32bits or max 64 but range could be liek 3*10^4
	public int bitMan()
	{
			
		//setting bits in a according to array value
		for(int i=0;i<list.size();i++)
		{
			int ele=list.get(i);
			
			//checking the set bits if any
			int set_bit= a & (1 << (ele) );
			
			if( set_bit> 0 ) return ele ; 
		
			a= a | ( 1 << (ele) );
		}
		
		
		return -1;
	}
	
	
	//2. Frequency method, also works for multiple repeated elements
	public void DupFreq()
	{
		int size=list.size();
		int index,freq;
		
		//increase the frequency or value of elements by n
		for(int i=0;i<size;i++)
		{
			index= (list.get(i)) % size;
			list.set(index, (list.get(index)  + size) ) ;
		}
		
		//repeating elements are with freq>1
		for(int i=0;i<size;i++)
		{
			freq= list.get(i) / size;
			if(freq >1) 
			{ 
					System.out.println("elem : "+ i); 
			}
		}
	
			
		return ;
	}
	
	
	//3. Find linked list cycle,  The cycle appears because nums contains duplicates. The duplicate node is a cycle entrance.
	public int findCycle()
	{
			
		 int slow = list.get(0);
		 int fast = list.get(0);
		 
	    do {
		      slow= list.get(slow);
		      fast=list.get(list.get(fast));
		     
		    } while (slow != fast);

		    // Find the "entrance" to the cycle.
	    	slow=list.get(0);
		    while (slow != fast) {
		    	slow= list.get(slow);
			    fast=list.get(fast);
		    }

		    return fast;
		  
	}
	

	public static void main(String[] args) 
	{
	
			DuplicateNumber obj=new DuplicateNumber();
			int arr[] = {13,46,8,11,20,17,40,13,13,13,14,1,13,36,48,41,13,13,13,13,45,13,28,42,13,10,15,22,13,13,13,13,23,9,6,13,47,49,16,13,13,39,35,13,32,29,13,25,30,13};
			for (int i : arr) 
			{
				obj.list.add(i);
			}
			
			System.out.println(obj.findCycle());
	}

}
