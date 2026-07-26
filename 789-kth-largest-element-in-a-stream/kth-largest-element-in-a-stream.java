class KthLargest {
    PriorityQueue<Integer> pq;
    int r;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        r = k;
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() >r) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */