/*

Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for a palindrome partitioning of a given string

*/
//Time Complexity: O(n3)
static int minPalPartion(String str)
{
        int n = str.length();
 
          /*C[i][j] = Minimum number of cuts needed 
                     for palindrome partitioning
                     of substring str[i..j]
           P[i][j] = true if substring str[i..j] is
                     palindrome, else false
           Note that C[i][j] is 0 if P[i][j] is
           true */
        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];
 
        int i, j, k, L; // different looping variables
 
        // Every substring of length 1 is a palindrome
        for (i = 0; i < n; i++) {
            P[i][i] = true;
            C[i][i] = 0;
        }
 
        
        for (L = 2; L <= n; L++) 
        {
            
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1; // Set ending index
 
                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
 
                // IF str[i..j] is palindrome, then
                // C[i][j] is 0
                if (P[i][j] == true)
                    C[i][j] = 0;
                else {
                    // Make a cut at every possible
                    // localtion starting from i to j,
                    // and get the minimum cost cut.
                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        C[i][j] = Integer.min(C[i][j],
                                              C[i][k] + C[k + 1][j] + 1);
                }
            }
        }
 
        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[0][n - 1];
    }


    //O(n2)
    static int minPalPartion(String str)
    {
        // Get the length of the string
        int n = str.length();
 
        /* Create two arrays to build the solution
        in bottom up manner
           C[i] = Minimum number of cuts needed for
           palindrome partitioning of substring
           str[0..i]
           P[i][j] = true if substring str[i..j] is 
           palindrome, else false
           Note that C[i] is 0 if P[0][i] is true */
        int[] C = new int[n];
        boolean[][] P = new boolean[n][n];
 
        int i, j, k, L; // different looping variables
 
        // Every substring of length 1 is a palindrome
        for (i = 0; i < n; i++) {
            P[i][i] = true;
        }
 
        /* L is substring length. Build the solution 
        in bottom up manner by considering all substrings 
        of length starting from 2 to n. */
        for (L = 2; L <= n; L++) {
            // For substring of length L, set different
            // possible starting indexes
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1; // Set ending index
 
                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
            }
        }
 
        for (currentIndex = 0; currentIndex < n; currentIndex++) {
			if (P[0][currentIndex] == true)
						C[currentIndex] = 0; // Solved by case 1
			else {
					C[currentIndex] = currentIndex; // If you think about it, at the worst case all characters are different and the min cut required is (num characters - 1)
					// Solve by case 2 - making 'palindromic' cuts
			for (int cutPoint = 0; cutPoint < currentIndex; cutPoint++) {
				if (P[cutPoint + 1][currentIndex] == true && 1 + C[cutPoint] < C[currentIndex])
					C[currentIndex] = 1 + C[cutPoint];
							}
				}
			}
 
        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[n - 1];
    }