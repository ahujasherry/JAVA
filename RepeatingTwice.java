/*
 * 
 * Find the two repeating elements in a given array
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 * 
 */

import java.util.ArrayList;
public class RepeatingTwice 
{
	private ArrayList<Integer> list;
	
	public RepeatingTwice()
	{
		list=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			list.add(null);
		}
	}
	
	private void findTwiceRepeated()
	{
		for (int i = 0; i < list.size(); i++) 
		{
				int absEle=Math.abs(list.get(i));
			
				if(list.get(absEle) >0 )
				{
					list.set(absEle, -1* Math.abs(list.get(absEle)) );
				}
				else
				{
					System.out.println("Rep ele + "+ Math.abs( list.get(i) )+ " "); 
				}
				
		
		}
		
	}
	

	public static void main(String[] args) 
	{
	
			RepeatingTwice obj=new RepeatingTwice();
			int arr[] = {6, 2, 4, 5, 5, 3, 1}; 
			for (int i : arr) 
			{
				obj.list.add(i);
			}
			
			obj.findTwiceRepeated();
	}

}
