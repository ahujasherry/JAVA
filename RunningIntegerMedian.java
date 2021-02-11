class MedianFinder {

    private Queue<Integer> minHeap, maxHeap;
    public MedianFinder() 
    {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
    }
    
    
    public void addNum(int num)
    {
        //min heap on right to keep min of max elements of median
        //max heap on left to keep max of min elements of median
        //if num< min , put in left max heap
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
            //keep sizes equal or diff<=1
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        
        } else {
            //if num> min heap top put in right
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
       
        
    }
    
    public double findMedian()
    {
        double median;
       
        //whoever has greater no of elements, median is that otherwise avg
        if (minHeap.size() < maxHeap.size()) {
            median = maxHeap.peek();
            
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();

        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return median;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */