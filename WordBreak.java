//recursion
public static boolean wordBreak(String word) 
{ 
        int size = word.length(); 
          
        // base case 
        if (size == 0) 
        return true; 
          
        //else check for all words 
        for (int i = 1; i <= size; i++) 
        { 
            // Now we will first divide the word into two parts , 
            // the prefix will have a length of i and check if it is  
            // present in dictionary ,if yes then we will check for  
            // suffix of length size-i recursively. if both prefix and  
            // suffix are present the word is found in dictionary. 
  
            if (dictionary.contains(word.substring(0,i)) &&  
                    wordBreak(word.substring(i,size))) 
            return true; 
}


//DP, O(n3)
 public boolean wordBreak(String s, List<String> wordDict)
    {
         boolean[] dp = new boolean[s.length() + 1];
        //SEARCH O(1)
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        //Dp{i} means if string till (0,i) included is present in dict or not
         dp[0] = true;
         for (int i = 1; i <= s.length(); i++) 
         {
            for (int j = i - 1; j >= 0; j--) 
            {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                //if word found
                if(dp[i]) break;
        }
    }
    return dp[s.length()];
        
    }