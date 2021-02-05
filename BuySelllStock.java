// its same problem as finding max difference between 2 elements in array if only one transaction is allowed

class Interval {
    int buy, sell;
}
class Solution 
{

    // one time transaction
    public int maxProfit(int[] arr) 
    {
        if(arr.length< 2 ) return 0;
        
        int max_diff = arr[1] - arr[0]; 
        int min_element = arr[0]; 
        int i; 
        for (i = 1; i <arr.length ; i++)  
        { 
            if (arr[i] - min_element > max_diff) 
                max_diff = arr[i] - min_element; 
            if (arr[i] < min_element) 
                min_element = arr[i]; 
        } 
        
        if(max_diff>0 )       return max_diff; 
        else return 0;
    }

	//multiple trans allowed
	static int maxProfit(int price[], int start, int end)
	{
 		//base case
    		if (end <= start)
        	return 0;
 
    
                 int profit = 0;
 
   		 // buy ith day
    		for (int i = start; i < end; i++) 
  		  {
 
       			//sell jth day 
			for (int j = i + 1; j <= end; j++)
       			 {
 
           			 // If byuing the stock at ith day and
           			 // selling it at jth day is profitable
           			 if (price[j] > price[i]) 
           			 {
 
               				 // Update the current profit
					// check max on left and right side of i and j
               				 int curr_profit = price[j] - price[i]
                         	       + maxProfit(price, start, i - 1)
                       		         + maxProfit(price, j + 1, end);
 
               				 // Update the maximum profit so far
               				 profit = Math.max(profit, curr_profit);
           		 }
        	}
    }
    return profit;
	}

	//multiple transactions in one go
	//find local minima and local maxima and sum them to get global max
	void stockBuySell(int price[], int n)
    {
        // Prices must be given for at least two days
        if (n == 1)
            return;
 
        int count = 0;
 
        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();
 
        // Traverse through given price array
        int i = 0;
        while(i< n)
        {
        	//find local minim for buy
        	while(i<n-1 && price[i+1]<=price[i]) i++;

        	if(i==n-1) break;

        	Interval e = new Interval();
            e.buy = i++;


			//find local maxima for sell
        	while(i<n && price[i]>=price[i-1]) i++;

        	e.sell = i - 1;
            sol.add(e);

            count++;

        }
        return count;
    }
}