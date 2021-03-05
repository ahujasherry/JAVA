import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        //split into tokens based on these symbols
        String[] arr=s.split("[ !,?._'@]+");
        System.out.println(arr.length);
        for(String st:arr)
        {
            System.out.println(st);
        }
        
        
        
        
        scan.close();
    }
}

