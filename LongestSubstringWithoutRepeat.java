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
		// Creating a set to store the last positions of occurrence
    HashMap<Character, Integer> seen = new HashMap<>(); 
    int maximum_length = 0;
 
    // starting the inital point of window to index 0
    int start = 0;
 
    for(int end = 0; end < s.length(); end++)
    {
      // Checking if we have already seen the element or not
      if(seen.containsKey(s.charAt(end)))
      {
        // If we have seen the number, move the start pointer
        // to position after the last occurrence
        start = Math.max(start, seen.get(s.charAt(end)) + 1);
      }
 
      // Updating the last seen value of the character
      seen.put(s.charAt(end), end);
      maximum_length = Math.max(maximum_length, end-start + 1);
    }
    return maximum_length;
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
