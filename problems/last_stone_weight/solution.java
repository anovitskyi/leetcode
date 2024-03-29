class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int diff = Math.abs(queue.poll() - queue.poll());

            if (diff == 0) {
                continue;
            }

            queue.offer(diff);
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}