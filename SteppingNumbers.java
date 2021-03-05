class Main
{
    public static boolean isStepNum(int n)
    {
        // Initalize prevDigit with -1
        int prevDigit = -1;
 
        while (n > 0)
        {
            int curDigit = n % 10;
 
            // Single digit is consider as a
            // Stepping Number
            if (prevDigit != -1)
            {
                if (Math.abs(curDigit-prevDigit) != 1)
                    return false;
            }
            n /= 10;
            prevDigit = curDigit;
        }
        return true;
    }
 
    public static void displaySteppingNumbers(int n,int m)
    {
        // Iterate through all the numbers from [N,M]
        // and check if it is a stepping number.
        for (int i = n; i <= m; i++)
            if (isStepNum(i))
                System.out.print(i+ " ");
    }
 
    // Driver code
    public static void main(String args[])
    {
        int n = 0, m = 21;
 
        displaySteppingNumbers(n,m);
    }
}