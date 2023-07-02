class KthLargest {
    int k;
    Queue<Integer> heap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num:nums) {
            heap.add(num);
        }
        while(heap.size() > k) {
            heap.remove();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k){
            heap.remove();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */