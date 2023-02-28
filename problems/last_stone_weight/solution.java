class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            int diff = first - second;
            if (diff > 0) {
                queue.offer(diff);
            }
        }

        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }
}