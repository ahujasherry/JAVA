/*

	Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number

*/


//since right side should be larger, keep min element and max diff track coming from left side.
int maxDiff(int arr[], int arr_size)  
{ 
        int max_diff = arr[1] - arr[0]; 
        int min_element = arr[0]; 
        int i; 
        for (i = 1; i < arr_size; i++)  
        { 
            if (arr[i] - min_element > max_diff) 
                max_diff = arr[i] - min_element; 
            if (arr[i] < min_element) 
                min_element = arr[i]; 
        } 
        return max_diff; 
} 


//Indirect kadance algo, make a difference array. Now find largest continuos subarray of difference
static int maxDiff (int arr[], int n)  
{  
    int diff = arr[1] - arr[0];  
    int curr_sum = diff;  
    int max_sum = curr_sum;  
  
    for(int i = 1; i < n - 1; i++)  
    {  
        // Calculate current diff  
        diff = arr[i + 1] - arr[i];  
  
        // Calculate current sum  
        if (curr_sum > 0)  
        curr_sum += diff;  
        else
        curr_sum = diff;  
  
        // Update max sum, if needed  
        if (curr_sum > max_sum)  
        max_sum = curr_sum;  
    }  
  
    return max_sum;  
}  