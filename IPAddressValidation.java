import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

//validate IP
// valid ip 1.2.123.255
//leading zeros allowed, len<=3

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex
{
    public String s="([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    public String pattern=s + "\\." + s + "\\." + s + "\\." + s;
    
}
