
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
	
	

	
	//1. Bit manipulation
	public int bitMan()
	{
			
		//setting bits in a according to array value
		for(int i=0;i<list.size();i++)
		{
			int ele=list.get(i);
			
			//checking the set bits if any
			int set_bit=a & (1 << (ele-1) );
			
			if( set_bit> 0 ) return ele ; 
		
			a= a | ( 1 << (ele-1) );
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
	

	public static void main(String[] args) 
	{
	
			DuplicateNumber obj=new DuplicateNumber();
			int arr[] = {1, 2, 2, 4}; 
			for (int i : arr) 
			{
				obj.list.add(i);
			}
			
			obj.DupFreq();
	}

}
