class KthLargest {

    private final Queue<Integer> heap;
    private final int sizeLimit;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.sizeLimit = k;

        for (int i = 0; i < nums.length; ++i) {
            heap.offer(nums[i]);

            if (heap.size() > sizeLimit) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.offer(val);

        if (heap.size() > sizeLimit) {
            heap.poll();
        }

        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */