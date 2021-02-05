class Solution {
    
    /*
    //T.C = n2, S.C = O(n)
    public int lengthOfLIS(int[] arr)
    {
        int n=arr.length;
        if(n==1) return 1;
        if(arr==null ) return 0;
       
        
          int lis[] = new int[n]; 
          int i,j,max = 0; 
  
          // Initialize LIS values for all indexes //
           for ( i = 0; i < n; i++ ) 
              lis[i] = 1; 
  
           // Compute optimized LIS values in bottom up manner //
           for ( i = 1; i < n; i++ ) 
              for ( j = 0; j < i; j++ )  
                         if ( arr[i] > arr[j] &&  
                                  lis[i] < lis[j] + 1) 
                         {
                                lis[i] = lis[j] + 1;
                         }
                     
  
           // Pick maximum of all LIS values //
           for ( i = 0; i < n; i++ ) 
              if ( max < lis[i] ) 
                 max = lis[i]; 
  
            return max; 
        
    }*/
    
    //T.C nlogn
    public int lengthOfLIS(int[] nums)
    {
        //contains increasing subseq
        int[] tails = new int[nums.length];
        
        int size = 0;
        for (int x : nums)
        {
            //j =size of tails array. increase whenever we add element at last
            // tails always increasing. SO use binary search
            int i = 0, j = size;
                 
            //binary search
            while (i != j) 
            {
                int m = (i + j) / 2;
               
                //search new element in tails. if its greater than last, add it to extend
                //sub seq otherwise replace at right pos, to extend possible subseq with
                //other new elemets
                if (tails[m] < x)
                {
                        i = m + 1;
                    
                }else
                {
                     j = m;
                    
                }
                   
                
            }
            tails[i] = x;
             
            if (i == size) ++size;
         }
        return size;
        
    }
}