class Solution {
    
    /*
    //Dp
    public String longestPalindrome(String str)
    {
        int n = str.length();
        
        if(str==null || n==1) return str;
        boolean table[][] = new boolean[n][n];
       
        int  maxLength=1;
        //length=1 are true always
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
        
        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
              start = i;
                maxLength = 2;
            }
        }
        
        //k==length
        for (int k = 3; k <= n; ++k) {
            
            //start point
            for (int i = 0; i < n - k + 1; ++i) {
                
                //ending index of curr wind
                int j = i + k - 1;
 
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j))
                {
                    table[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        
        return str.substring(start,start + maxLength);
        
        
    }*/
   
    //keep track of odd and even length palindromes
    public String longestPalindrome(String str)
    {
        int maxLength = 1; 
  
        int start = 0; 
        int len = str.length(); 
  
        int low, high; 
  
        // One by one consider every 
        // character as center 
        // point of even and length 
        // palindromes 
        for (int i = 1; i < len; ++i) { 
           
            // Find the longest even 
            // length palindrome with 
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len 
                   && str.charAt(low) 
                          == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
  
            // Find the longest odd length 
            // palindrome with center point as i 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                   && str.charAt(low) 
                          == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        } 
  
      
        return str.substring(start,start + maxLength); 
    }
}