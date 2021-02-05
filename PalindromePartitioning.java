class Solution {
    List<List<String>> res;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) 
    {
        res = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        helper(s,0);
        return res;
    }
    public void helper(String s,int start)
    {
        if(start >= s.length())
        {
            res.add(new ArrayList<>(currLst));
        }
        
        for(int i=start;i<s.length();i++)
        {
            if(isPalindrome(s, start, i))
            {
                currLst.add(s.substring(start,i+1));
                helper(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    
    private static boolean isPalindrome(String input, int l, int r) 
                                     
    { 
      if(r==l) return true;  
        while (l < r)  
        { 
            if (input.charAt(l++) != input.charAt(r--)) 
                return false; 
        } 
        return true; 
    } 
}