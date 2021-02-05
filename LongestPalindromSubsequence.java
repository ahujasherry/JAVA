 static int lps(char seq[], int i, int j) { 
    // Base Case 1: If there is only 1 character  
        if (i == j) { 
            return 1; 
        } 
  
    // Base Case 2: If there are only 2 characters and both are same  
        if (seq[i] == seq[j] && i + 1 == j) { 
            return 2; 
        } 
  
    // If the first and last characters match  
        if (seq[i] == seq[j]) { 
            return lps(seq, i + 1, j - 1) + 2; 
        } 
  
    // If the first and last characters do not match  
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j)); 
 }



static int lps(String seq) 
{ 
    int n = seq.length(); 
    int i, j, cl; 
    // Create a table to store results of subproblems 
    int L[][] = new int[n][n];  
      
    // Strings of length 1 are palindrome of lentgh 1 
    for (i = 0; i < n; i++) 
        L[i][i] = 1; 
        
	
        for (cl=2; cl<=n; cl++) 
        { 
            for (i=0; i<n-cl+1; i++) 
            { 
                j = i+cl-1; 
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) 
                L[i][j] = 2; 
                else if (seq.charAt(i) == seq.charAt(j)) 
                L[i][j] = L[i+1][j-1] + 2; 
                else
                L[i][j] = max(L[i][j-1], L[i+1][j]); 
            } 
        } 
              
        return L[0][n-1]; 
 } 
          
   