
//recursive T.C = exponential
static int MatrixChainOrder(int p[], int i, int j) 
    { 
        if (i == j) 
            return 0; 
  
        int min = Integer.MAX_VALUE; 
  
        // place parenthesis at different places between 
        // first and last matrix, recursively calculate 
        // count of multiplications for each parenthesis 
        // placement and return the minimum count 
        for (int k = i; k < j; k++)  
        { 
            int count = MatrixChainOrder(p, i, k) 
                        + MatrixChainOrder(p, k + 1, j) 
                        + p[i - 1] * p[k] * p[j]; 
  
            if (count < min) 
                min = count; 
        } 
  
        // Return minimum count 
        return min; 
    } 


    //memoization
    int matrixChainMemoised(int* p, int i, int j) 
{ 
    if (i == j)  
    { 
        return 0; 
    } 
    if (dp[i][j] != -1)  
    { 
        return dp[i][j]; 
    } 
    dp[i][j] = INT_MAX; 
    for (int k = i; k < j; k++)  
    { 
        dp[i][j] = min( 
            dp[i][j], matrixChainMemoised(p, i, k) 
                     + matrixChainMemoised(p, k + 1, j) 
                       + p[i - 1] * p[k] * p[j]); 
    } 
    return dp[i][j]; 
} 
int MatrixChainOrder(int* p, int n) 
{ 
    int i = 1, j = n - 1; 
    return matrixChainMemoised(p, i, j); 
}


//Dp O(n3)
static int MatrixChainOrder(int p[], int n) 
    { 
       
        int dp[][] = new int[n][n]; 
        int i, j, k, L, q; 
  
        
        // cost is zero when multiplying one matrix. 
        for (i = 1; i < n; i++) 
            dp[i][i] = 0; 
  
        // L is chain length. 
        for (L = 2; L < n; L++)  
        { 
            for (i = 1; i < n - L + 1; i++)  
            { 
                j = i + L - 1; //end index
                
                if (j == n) 
                    continue; 
                
                dp[i][j] = Integer.MAX_VALUE; 
                
                for (k = i; k <= j - 1; k++)  
                { 
                    q = dp[i][k] + dp[k + 1][j] 
                        + p[i - 1] * p[k] * p[j]; 
                    if (q < dp[i][j]) 
                        dp[i][j] = q; 
                } 
            } 
        } 
  
        return dp[1][n - 1]; 
    } 