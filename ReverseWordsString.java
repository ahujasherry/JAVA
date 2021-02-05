class Solution {
   /*
    //using built in functions
    public String reverseWords(String s) 
    {
        
        String tmp[]=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        sb.append("");
        for(int i=tmp.length-1;i>=0;i--)
        {
            sb.append(tmp[i]);
            
            sb.append(" ");
        }
        return sb.toString().trim();
    }*/
    
    //in place without library
    public String reverseWords(String s) 
    {
        StringBuilder sb=new StringBuilder();
        sb.append("");
        int i=s.length()-1;
        int j=0;
        while(i>=0)
        {
            
            if(s.charAt(i)== ' ' )
            {
                i--;
                continue;
            }
            
            j=i-1;
            
            //for multiple white spaces
            while(j>=0 &&s.charAt(j)!=' ') j--;
            
            //will append one initial whitespace 
            //but cover last word whitespace problem
            sb.append(" ");
            
            sb.append(s.substring(j+1,i+1));
            i=j-1;
           
            
            
        }
        return (sb.length()>0)?                 sb.deleteCharAt(0).toString():sb.toString();
    }
    
}