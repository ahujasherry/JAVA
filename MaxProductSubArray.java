class Solution 
{
	
	// T.C O(n) , S.C O(1)
    public int maxProduct(int[] nums)
    {
        int ans=nums[0],min=ans=nums[0],max=ans=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==0)
            {   
                max=0;
                min=0;
            }

            //if ans flips becaue of a[i] negative
            int temp=max;
            max=Math.max(Math.max(nums[i]*max,nums[i]*min),nums[i]);
            min=Math.min(Math.min(nums[i]*temp,nums[i]),min*nums[i]);   
            ans=Math.max(ans,max);
            
        }
        return ans;
    }
}