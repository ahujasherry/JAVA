//find inversion pairs in array. We using enhanced merge sort

private static int mergeAndCount(int[] arr,  
                                int l, int m, int r) 
{ 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, inv= 0; 
  
        while (i < left.length && j < right.length)  
        { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                inv+= m-i; 
            } 
        } 
        return inv;
    } 
  
// Merge sort function 
private static int mergeSortAndCount(int[] arr,  
                                        int l, int r) 
    { 
  
        int count = 0; 
  
        if (l < r) { 
            int m = (l + r) / 2; 
  
         
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    } 