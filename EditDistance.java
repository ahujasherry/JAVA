//recursive
static int editDist(String str1, String str2, int m,
                        int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;
 
        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;
 
        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);
 
        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1
            + min(editDist(str1, str2, m, n - 1), // Insert
                  editDist(str1, str2, m - 1, n), // Remove
                  editDist(str1, str2, m - 1,
                           n - 1) // Replace
              );
    }


//DP 
//S.C O(m*n)
 static int editDistDP(String str1, String str2, int m,
                          int n)
    {
        int dp[][] = new int[m + 1][n + 1];
 
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
              
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j
 
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i
 
                // If last characters are same, ignore last
                // char and recur for remaining string
                else if (str1.charAt(i - 1)
                         == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
 
                // If the last character is different,
                // consider all possibilities and find the
                // minimum
                else
                    dp[i][j] = 1
                               + min(dp[i][j - 1], // Insert
                                     dp[i - 1][j], // Remove
                                     dp[i - 1]
                                       [j - 1]); // Replace
            }
        }
 
        return dp[m][n];
    }

    //space : O(m)
    public int minDistance(String str1, String str2)
    {
        
        
        int len1=str1.length();
        int len2=str2.length();
        
        if(len1==0) return len2;
        if(len2==0) return len1;
        
        int dp[][] = new int[2][len1+1];
 
        // Base condition when second String
        // is empty then we remove all characters
        for (int j = 0; j <= len1; j++)
          dp[0][j] = j;
        
        //for every character in str2
        for (int i = 1; i <=len2 ; i++)
        {
            //for every char in str1
            for (int j = 0; j <= len1 ; j++) 
            {
                // if first String is empty then
                // we have to perform add character
                // operation to get second String
                if (j == 0)
                    dp[i%2][j] = i; // Min. operations = i
 
                else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                        dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
            }
 
                else
                {
                    dp[i % 2][j] = 1 + Math.min(dp[(i - 1) % 2][j],
                                       Math.min(dp[i % 2][j - 1],
                                           dp[(i - 1) % 2][j - 1]));
                    
                }
                     
            }
        
    }
        return dp[len2%2][len1];
    }