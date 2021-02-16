/*
    Approaches:
    1. Sorting T.C O(nlogn) 
    2. hash map or count array T.C O(n)
    3. sum of each char and match it T.C O(n) S.C O(1)  

*/
class Solution 
{
    public static final int NO_OF_CHARS=256;
    
    public boolean isAnagram(String s, String t) 
    {
        int m=s.length();
        int n=t.length();
    
        //if lengths are different, not anagrams
        if(m!=n) return false;
        
        //count array
        int[] count=new int[NO_OF_CHARS];
        
        //for same characters, one will increase and other will decrease. Final count should be 0
        for(int i=0;i<m;i++)
        {
            count[ s.charAt(i) -'a']++;
            
        }
        for(int i=0;i<n;i++)
        {
            count[ t.charAt(i) -'a']--;
            if(count[ t.charAt(i) -'a'] <0 ) return false;
            
        }
        for(int i=0;i<NO_OF_CHARS;i++)
        {
            
            if( count[i]!=0) return false;
        }
        return true;
        
        
    }
}