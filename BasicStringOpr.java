import java.io.*;
import java.util.*;

public class Solution {

    public static void strs(String a, String b)
    {
        int sum=a.length()+b.length();
        System.out.println(sum);
        
        
        if(a.compareTo(b)>0)
            System.out.println("Yes");
        else 
            System.out.println("No");
            
        String firstUpperChar=String.valueOf(a.charAt(0)).toUpperCase();
        String restFirstStr=a.substring(1);
        String secondUpperChar=String.valueOf(b.charAt(0)).toUpperCase();
        String restSecondStr=b.substring(1);
        
        System.out.println(firstUpperChar+restFirstStr+" "+secondUpperChar+restSecondStr);
        
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        strs(A,B);
        
    }
}



