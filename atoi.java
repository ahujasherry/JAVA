class Solution {
    public int myAtoi(String str) 
    {
        if(str == null || str.length() == 0) return 0;
        
        //index, sign, final ans
        int ptr = 0, sign = 1;
        long ans = 0;
        
        //skip leading white spaces
        while(ptr< str.length() && str.charAt(ptr) == ' ') ptr++;
        
        //if we reach end
        if(ptr >= str.length()) return 0;
        
        //skip the sign and store if negative
        if(str.charAt(ptr) == '+') ptr++;
        else if(str.charAt(ptr) == '-'){
            sign = -1;
            ptr++;
        }
        
        //character should be digit
        while(ptr < str.length() && Character.isDigit((str.charAt(ptr))))  
        {
            //convert char into digit
            int num = str.charAt(ptr) - '0';
            
           
            //build number
            ans = 10*ans + num;
         
          
            if(ans>Integer.MAX_VALUE && sign==1) return Integer.MAX_VALUE;
            else if( ans>Integer.MAX_VALUE && sign==-1) return                                  Integer.MIN_VALUE;
            
            ptr++;
        }
        return sign * (int)ans;
        
    }
}