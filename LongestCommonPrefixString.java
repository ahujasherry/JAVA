class Solution {
    public String longestCommonPrefix(String[] strs)
    {
        StringBuilder  sb=new StringBuilder("");
        if(strs.length==0)
            return sb.toString();
        int max_n=10000;
        for(int i=0;i< strs.length; i++)
        {
            max_n=Math.min(max_n,strs[i].length());    
        }
        char arr[][]=new char[strs.length][max_n];
        
        for(int i=0;i< strs.length; i++)
        {
            arr[i]=strs[i].toCharArray();    
        }
        
        int i=0,j=0, m=strs.length,n=max_n;
        boolean notEqual=false;
        
        while(j< max_n )
        {
               notEqual=false;
               i=0;
               while(i<m-1)
               {
                   if(strs[i].length()==0)
                   {
                       notEqual=true;
                       break;
                   }
                   else if(arr[i][j]!=arr[i+1][j]) 
                   {
                            notEqual=true;
                            break;
                   }
                   i++;
               }
              if(!notEqual)
                  sb.append(arr[i][j]);
              else 
                  break;
            
              j++;
                          
        }
            return sb.toString();
                          
        
        
    }
}