class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            queue.offer(i);
            if (queue.size() >= k) {
                while (queue.peek() < i - k + 1) {
                    queue.poll();
                }
                result[index++] = nums[queue.peek()];
            }
        }
        return result;
    }
}