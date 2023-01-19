class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<int[]> window = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0, resultIndex = 0; i < nums.length; ++i) {
            window.offer(new int[] {nums[i], i});
            
            if (window.size() < k) {
                continue;
            }

            while (!window.isEmpty() && window.peek()[1] <= (i - k)) {
                window.poll();
            }

            result[resultIndex++] = window.peek()[0];
        }

        return result;
    }
}