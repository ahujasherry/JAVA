
/*
    n2 -> store all pair sum in hash(n2). again traverse pairs and check for remaining sum. 
    keep check of all distinct elements. To handle duplicate, keep separate temp array as visited one
    
*/

//n3 T.c
class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        //Resultant list
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        //invalid input
        if(nums==null || nums.length<4) return res;
        
        //sort the input array
        Arrays.sort(nums);
        
        int n=nums.length;
        
        //run 2 pointers as i and j
        for(int i=0;i<n-3;i++)
        {
            //skip duplicates
            while(i>0 && nums[i]==nums[i-1]) continue;
            
            for(int j=i+1;j<n-2;j++)
            {
                ////skip duplicates
                while(j>i+1 && nums[j]==nums[j-1]) continue;
                
                int sum=nums[i]+nums[j]; 
                int rem_sum= target-sum;
                
                //point start pointer next to j
                int s=j+1;
                int e=n-1;
                while(s<e)
                {
                    //if quad found, add to result
                    if(nums[s]+nums[e] ==rem_sum)
                    {
                        List<Integer> temp = new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
                        res.add(temp);
                        //skip duplicates
                        while(s<e && nums[s]==nums[s-1]) continue;
                        while(s<e && nums[e]==nums[e+1]) continue;
                        s++; e--;
                    }
                    else if(nums[s]+nums[e] < rem_sum)
                    {
                        //skip duplicates
                        while(s<e && nums[s]==nums[s-1]) continue;
                        s++;
                    }else
                    {
                        //skip duplicates
                        while(s<e && nums[e]==nums[e+1]) continue;
                        e--;
                    }
                }
            }
        }
        return res;
    }
}