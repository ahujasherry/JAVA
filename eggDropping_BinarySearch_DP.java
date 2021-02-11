class Solution 
{
    /*Dp 
    //T.C O(k*n^2)
    public int superEggDrop(int k, int n)
    {
        int dp[][]=new int[k+1][n+1];
        
        for (int i = 1; i <= k; i++) { 
            dp[i][1] = 1; 
            dp[i][0] = 0; 
        } 
        
        for (int j = 1; j <= n; j++) 
            dp[1][j] = j; 
        
        int i,j,x,res;
        for (i = 2; i <= k; i++) 
        { 
            for (j = 2; j <= n; j++) 
            { 
                dp[i][j] = Integer.MAX_VALUE; 
                for (x = 1; x <= j; x++) 
                { 
                    res = 1 + Math.max(dp[i - 1][x - 1],dp[i][j - x]); 
                    if (res < dp[i][j]) 
                        dp[i][j] = res; 
                } 
            } 
        } 
            
        
        
        return dp[k][n];
           
    }*/
    
    
    public int superEggDrop(int k, int n)
    {
        int dp[][]=new int[k+1][n+1];
        return helper(k,n,dp);
    }
    
    //with Binary search,  T.C = O(knlogn)
    public int helper(int k, int n, int[][] dp)
    {
        //if floors equal to 0 or 1
        if(n<=1) return n;
        
        //if 1 egg left, no of floor is ans
        if(k==1) return n;
        
        //memoization
        if(dp[k][n]> 0 ) return dp[k][n];
        
        //start, end , result
        int s=1, e=n, res=n;
        
        //B.S
        while(s<e)
        {
            int mid=s+(e-s)/2;
            
            //if egg brokes, check left side
            int left=helper(k-1, mid-1,dp);
            
            //if doesnt break, check right side
            int right=helper(k,n-mid,dp);
            
            //final res
            res= Math.min(res, Math.max(left,right)+1);
            
            //we found the critical floor and min moves
            if(left==right){
                break;
            }
            //we need max worst case, check in right
            else if( left < right)
            {
                s=mid+1;
            }
            //check in left
            else
            {
                e=mid;
            }
            
            
        }
        dp[k][n]=res;
        return res;
        
    }
    
}