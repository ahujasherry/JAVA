/*Search element in 2d sorted matrix from left to right in increasing order
 start from top right corner. 3 cases
    1.  ele > target -> check prev columns
    2   ele < target -> check next rows
    3.  ele == target -> found
*/
class Solution {
    
    /*
    T.C = O(m+n)
    S.C = O(1)
    public boolean searchMatrix(int[][] arr, int x) 
    {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return false;
        int i = 0, j = arr[0].length - 1;  
        boolean flag=false;
        while (i < arr.length && j >= 0)  
        { 
            if (arr[i][j] == x)  
            { 
               flag=true;
                break;
            } 
            else if (arr[i][j] > x) 
                j--; 
            else  
                i++; 
        } 
  
        return flag;
        
    }
*/    
    
    //T.C = O(logm+logn)
    //S.C = O(1)
     public boolean searchMatrix(int[][] arr, int x) 
    {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return false;
        int m=arr.length;
        int n=arr[0].length;
        int s=0, e=m*n-1;
         
        while (s <= e)  
        { 
            int mid=(s+e)/2;
            int val=arr[mid/n][mid%n];
            
            if (val == x)  
            { 
               return true;
            } 
            else if (val > x) 
                e=mid-1; 
            else  
                s=mid+1;
        } 
  
        return false;
        
    }
}