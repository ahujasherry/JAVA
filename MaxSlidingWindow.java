class Solution {
    
    /*//Brute Force
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || k <= 0) return new int [0];
        int [] arr = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
               max = Math.max(max, nums[j]);
            arr[i] = max;
        }
        return arr;
    }

    
    //deque solution
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //validate input
        if(nums == null || k <= 0) return new int [0];
        
        //stores maxiumum
        int [] arr = new int[nums.length - k + 1];
        int in = 0;
        
        //stores index of top k maxiumum
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            //remove element out of k range when we move fwd 
            if(!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
            
            //pop elements till current > popped
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])                                   dq.pollLast();
            
            
            dq.offer(i);
            
            //at k=3, starting from i=2,keep storing max element of every win
            if(i >= k - 1) arr[in++] = nums[dq.peek()];
        }
        return arr;
        
    }*/
    
    //can also be solved with Next greater element concept
     public int[] maxSlidingWindow(int[] nums, int k) 
    {
        //validate input
        if(nums == null || k <= 0) return new int [0];
              
        //stores maxiumum
        int [] arr = new int[nums.length - k + 1];
        int in = 0;
        
        //stores next greater elements
        int gr[]=nextGreaterElement1(nums);
            
        int j=0;
        for(int i = 0; i < nums.length-k+1; i++)
        {
                //if j remains back from i 
                if(j<i) j=i;
            
                //current window
                int currRange=i+k-1;
            
                //next greater is in window range
                while(  gr[j] <= currRange)
                {
                    //jump to next greater. in between elements from j to                           gr[j] will be smaller to gr[j]
                    j=gr[j];
                }
                
                //store ans for that window
                arr[in++]=nums[j];
            
        }
        return arr;
        
    }
    
    public int[] nextGreaterElement1(int[] arr)
    {
       if (arr == null || arr.length == 0)
            return arr;
        
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) 
        {
            while (!st.empty() && arr[st.peek()] < arr[i])
                result[st.pop()] = i;
            st.push(i);
        }
            while (!st.empty())
                result[st.pop()] = arr.length;

        return result;
    }
}