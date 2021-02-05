import java.util.*;

/* Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Solution: keep info about first row and column in 2 variables. Later on, use them as row[m] and col[n] to indicate where to update the 0 in the matrix excluding first row and column. 

    T.C = O(M*N)
    S.C = O(1)
*/

class Solution 
{
    public void setZeroes(int[][] arr) 
    {
        
        boolean rowFlag=false,colFlag=false;
        int m=arr.length;
        int n=arr[0].length;
        
        
        //updating flags of first row and column
        //and updating first  row and column values
        for(int i=0;i< m;i++)
        {
            for(int j=0;j< n;j++)
            {
                if(i==0 && arr[i][j]==0 ) rowFlag=true;
                if(j==0 && arr[i][j]==0 ) colFlag=true;
                
                if(arr[i][j]==0)
                {
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }
        
        
        //modifying arr values based on above excluding 1st row/col
        for (int i = 1; i < m; i++) 
        { 
            for (int j = 1; j < n; j++) 
            { 
  
                if (arr[0][j] == 0 || arr[i][0] == 0) arr[i][j] = 0; 
            }
        }
            
        //update first row/col
        if (rowFlag == true) 
        { 
            for (int i = 0; i < n; i++) 
            { 
              arr[0][i] = 0; 
            } 
        } 
  
        if (colFlag == true) 
        { 
            for (int i = 0; i <m; i++) 
            { 
                arr[i][0] = 0; 
            }
            
         } 
        
    }
}