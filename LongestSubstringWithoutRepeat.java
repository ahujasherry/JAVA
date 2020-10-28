/*
 * 
- * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * 
 */

import java.util.*;
public class LongestSubstringWithoutRepeat {

	
	//Time complexity= O(N)
	public static int subStrLinear(String str)
	{
		if(str.isEmpty()) return 0;
		 if(str.length()==1) return 1;
		int len=0,start=0,end=0,res=0;
		
		//array to store visited and last index
		int visited[]=new int[256];
		for (int k = 0; k < visited.length; k++) {
			visited[k]=-1;
		}
		
		while(end!=str.length())
		{
			//if in set
			
			if(visited[str.charAt(end)]!=-1)
			{
				visited[str.charAt(start)]=-1;
				start++;
			}
			else
			{
				visited[str.charAt(end)]=0;
				len=end-start+1;
				end++;
				
			}
			
			res=Math.max(len, res);
	
			
		}
		
			
		return res;
	}
	
	//average time complexity -> O(n2)
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
		String str = "abcabcbb"; 
	   
	    int len = subStrLinear(str); 
	    System.out.println("len: " + len); 
		

	}

}
