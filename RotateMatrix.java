//90 degrees rotate matrix in place
//1 take transpose and then reverse 

class Solution {
    public void rotate(int[][] arr) 
    {
        for(int i=0;i<arr.length;i++)
        {
            //transpose
            for(int j=i;j<arr[0].length;j++)
            {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
            
            //reverse
             for(int i=0;i<arr.length;i++)
            {
                 int li=0;
                 int ri=arr[0].length-1;
                 while(li<ri)
                 {
                    int temp1=arr[i][li];
                    arr[i][li]=arr[i][ri];
                    arr[i][ri]=temp1;
                    li++;
                    ri--;
                 }
                 
              
            }
        }
        
        
    }
