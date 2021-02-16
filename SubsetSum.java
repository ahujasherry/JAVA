
class SubsetSum 
{
	//Recursive, exp time complexity
	static boolean isSubsetSum(int set[],
								int n, int sum)
		{
			// Base Cases
			if (sum == 0)
				return true;
			if (sum < 0)
				return false;

	      boolean ans=false;
	      for(int i=0;i<n;i++)
	      {
	      	int rem_sum=sum - set[i];

	      	//or we can go with approach that ans1=included and ans2=not included and take OR of both
	        ans= ans | isSubsetSum(set, n, rem_sum);
	      }
	      return ans;
		}


	//DP 
	// T.C O(sum*n)
	static boolean isSubsetSum(int set[],int  n, int sum)
	{
		
			boolean subset[][] = new boolean[sum + 1][n + 1];

			// If sum is 0, then answer is true
        	for (int i = 0; i <= n; i++)
           	 subset[0][i] = true;

           	// If sum is not 0 and set is empty,
       		 // then answer is false
        	for (int i = 1; i <= sum; i++)
            	subset[i][0] = false;

            for (int i = 1; i <= sum; i++) 
            {
            	for (int j = 1; j <= n; j++) 
            	{
            		//not included in case of sum< element
                	subset[i][j] = subset[i][j - 1];

                	//included
                	if (i >= set[j - 1])
                    	subset[i][j] = subset[i][j]   || subset[i - set[j - 1]][j - 1];
            }
        }


	}

	//space optimization
	//S.C = O(sum)
	static boolean isSubsetSum(int arr[], int n, int sum) 
    { 
        // The value of subset[i%2][j] will be true  
        // if there exists a subset of sum j in  
        // arr[0, 1, ...., i-1] 
        boolean subset[][] = new boolean[2][sum + 1]; 
       
        for (int i = 0; i <= n; i++) 
        { 
            for (int j = 0; j <= sum; j++) 
            { 
       
                // A subset with sum 0 is always possible  
                if (j == 0) 
                    subset[i % 2][j] = true;  
       
                // If there exists no element no sum  
                // is possible  
                else if (i == 0) 
                    subset[i % 2][j] = false;  

                else if (arr[i - 1] <= j) 
                    subset[i % 2][j] = subset[(i + 1) % 2][j - arr[i - 1] ] || subset[(i + 1) % 2][j]; 
                else
                    subset[i % 2][j] = subset[(i + 1) % 2][j]; 
            } 
        } 
       
        return subset[n % 2][sum]; 
    } 

	public static void main(String args[])
		{
			int set[] = { 3, 34, 4 };
			int sum = 2;
			int n = set.length;
			if (isSubsetSum(set, n, sum) == true)
				System.out.println("Found a subset"
								+ " with given sum");
			else
				System.out.println("No subset with"
								+ " given sum");
		}
	}
}