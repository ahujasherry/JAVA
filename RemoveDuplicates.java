/*
 * 
 * Remove duplicates from sorted array
 */

import java.util.*;
public class RemoveDuplicates 
{
	
	//T.C-> O(n) , S.C -> O(1)
	public static int removeDuplicates(int arr[],int n)
	{
		if (n == 0 || n == 1) 
            return n; 
       
        //index for unique elements
		int index = 0; 
       
        for (int i = 0; i < n-1; i++) 
        {
        	//if unique, put in next unique index
            if (arr[i] != arr[i+1]) 
                arr[index++] = arr[i]; 
        }
        arr[index++] = arr[n-1]; 
        
        return index; 
	}
	public static void main(String[] args) {

        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}; 
        int n = arr.length; 
          
        n = removeDuplicates(arr, n); 
   
        // Print updated array 
        for (int i=0; i<n; i++) 
           System.out.print(arr[i]+" ");

	}

}
