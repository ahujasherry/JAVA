//recursion
static int findMinInsertions(char str[], int ,int h)
    {
        // Base Cases
        if (l > h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h - 1) return (str[l] == str[h])? 0 : 1;
 
        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which subrpoblem(s) to call
        return (str[l] == str[h])?
            findMinInsertions(str, l + 1, h - 1):
            (Integer.min(findMinInsertions(str, l, h - 1),
            findMinInsertions(str, l + 1, h)) + 1);
    }
 

 //DP
 static int findMinInsertionsDP(char str[], int n)
    {
        int table[][] = new int[n][n];
        int i, j, len;
 
        
        for (len = 1; len < n; ++len)
        {

            for (i = 0;i<n-len+1, i++)
            {
                j=i+len-1;

                table[i][len] = (str[e] == str[j])?table[i+1][j-1] :(Integer.min(table[i][j-1],table[i+1][j]) + 1);
            }
        }
        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n-1];
    }

    /*LCS
    Find the length of LCS of input string and its reverse. Let the length be ‘l’.
    The minimum number insertions needed is length of input string minus ‘l’.*/