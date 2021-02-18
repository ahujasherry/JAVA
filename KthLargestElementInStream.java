class KthLargest {
    //min heap
     PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) 
    {
         this.k = k;
        pq = new PriorityQueue<>();
        //maintain min heap of k size 
        for (int num : nums) add(num);
        
    }
    
    public int add(int val) 
    {
        //maintains top k largest elements 
        if (pq.size() < k || val > pq.peek()) pq.offer(val);
        
        //remove when added to keep size ==k
        if (pq.size() > k) pq.poll();
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */