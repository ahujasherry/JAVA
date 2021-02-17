class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int m=coins.length;
        int n=amount;
        long dp[][] = new long[m+1][n+1];
        
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                //amount==0
                if(j==0) dp[i][j]=0;

                //coins==0, store =infinity
                else if (i==0) dp[i][j]=Integer.MAX_VALUE;
                
                //exclude that coin
                else if (coins[i-1] > j) dp[i][j]=dp[i-1][j];
                
                //include
                else 
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1] ],dp[i-1][j] );
                        
            }
        }
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
               //System.out.print(dp[i][j]+" ");
                        
            }
            //System.out.println("");
        }
        
        if(dp[m][n]==Integer.MAX_VALUE) return -1;
        else return (int)dp[m][n];
    }
    
    
}