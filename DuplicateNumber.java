
/*
 * 
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times. Find these repeating numbers in O(n) 
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
	
	

	

	public static void main(String[] args) 
	{
	
			DuplicateNumber obj=new DuplicateNumber();
			int arr[] = {1, 2, 3, 5,3,5}; 
			for (int i : arr) 
			{
				obj.list.add(i);
			}
			
			System.out.print(obj.bitMan());
	}

}
