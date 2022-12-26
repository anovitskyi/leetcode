class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length - 1; ++i) {
            queue.offer(i + nums[i]);

            while (!queue.isEmpty() && queue.peek() <= i) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}