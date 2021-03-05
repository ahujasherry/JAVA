import java.io.*;
import java.util.*;

//print count of negative subarrays

public class Solution {

    public static int calculate(int[] arr,int n, int i , int j)
    {
        int sum=0;
        for(int index=i;index<=j;index++)
        {
            sum+=arr[index];
        }
        return sum;
    }
    public static int negSubArr(int[] arr,int n)
    {
        int count=0;
        
        for(int len=1;len<=n;len++)
        {
            //start index
            for(int start=0;start<= n-len;start++)
            {
                int end= start+len-1;
                int sum=calculate(arr,n,start,end);
                if(sum<0) count++;
                
            }
        }
        
        return count;
    }
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        
        System.out.println(negSubArr(arr,n));
        
        
    }
}