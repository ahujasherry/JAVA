/*
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * 
 */

import java.util.*;
public class LongestSubstringWithoutRepeat {

	
	//average time complexity -> O(n)
	public static int subStr(String str)
	{
		if(str.isEmpty()) return 0;
		int len=0;
		
		
		for (int i = 0; i < str.length(); i++) 
		{
			boolean visited[]=new boolean[256];
			for (int j = i; j < str.length(); j++) 
			{
				//if current jth character is already visited, break loop and move to next ith 
				if(visited[str.charAt(j)])
					break;
				//take the len and compare with global len and make current char as true
				else
				{
					len=Math.max(len, j-i+1);
					visited[str.charAt(j)]=true;
					
				}
				
			}
			
			//when element is removed from window, mark it as false
			visited[str.charAt(i)]=false;
			
			
		}
		return len;
	}
	public static void main(String[] args) 
	{
		String str = "pwwkew"; 
	   
	    int len = subStr(str); 
	    System.out.println("len: " + len); 
		

	}

}
