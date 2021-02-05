class Solution 
{
    //binary search
    // at left of req element, first occurence: even ,second occurence: odd
    // at right of req element, first occurence: odd ,second occurence: even
    static int ans;
    public int singleNonDuplicate(int[] arr) 
    {
        singleHelper(arr,0,arr.length-1);
        return ans;
    }
    
    public static void singleHelper(int []arr,int low,int high)
    {
        if(low> high) return;
        if(low==high) 
        {
            ans=arr[low];
            return;
        }
        
        int mid=(high+low)/2;
        
        //if mid is even
        if(mid%2==0)
        {
            //search right
            if(arr[mid]==arr[mid+1])
            {
                singleHelper(arr,mid+2,high);
            }else
            {
                singleHelper(arr,low,mid);
            }
            
        }else //mid is odd
        {
            //search right
            if(arr[mid]==arr[mid-1])
            {
                singleHelper(arr,mid+1,high);
            }else
            {
                singleHelper(arr,low,mid-1);
            }
            
        }
        
        
        
        
    }
}