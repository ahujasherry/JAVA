class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if(amount<1) return 0;
        return helperCoins(coins,new int[amount],arr);
    }
    
    public int helperCoins(int[] coins, int amount,int arr[])
    {
        if(amount ==0) return 0;
        if(amount < 0) return -1;
        
        if(arr[amount-1]!=0) return arr[amount-1];
        
        int res=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i< coins.length;i++)
        {
            if(amount>0)
            {
                 ans=1+coinChange(coins,amount-coins[i]);
            }
            if(ans>0) res=Math.min(res,ans);
        }
        
        arr[amount-1]= (res==Integer.MAX_VALUE) ? -1: res;
        return arr[amount-1];
        
    }
}