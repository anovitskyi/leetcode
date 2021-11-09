class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            queue.offer(i);
            
            while (i - queue.peek() >= k) {
                queue.poll();
            }
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        
        return result;
    }
}