class Solution {
    static int index;
    public Solution()
    {
        index=-1;
    }
    public int search(int[] arr, int target) 
    {
        helper(arr,0,arr.length-1,target);
        return index;
    }
    
    public static void helper(int []arr,int start,int end,int target)
    {
       
        while(start <= end)
        {
            int mid=(start+end)/2;
            //element found
            if(arr[mid]==target)
            {
                index=mid;
                return;
            }
            
            //left half sorted
            if( arr[start] <= arr[mid] )
            {
                //element lies in sorted range so search in left
                if(arr[start] <= target  && arr[mid] >= target)
                {
                     end=mid-1;
                    
                }
                else
                {
                   start=mid+1;
                }
            }else if( arr[mid] < arr[end]) //right half sorted
            {
                //element lies in sorted range so search in right
                if(arr[end] >= target  && arr[mid] <= target)
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
            
        }
        
        
    }

}