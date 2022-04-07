class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int weight : stones) {
            queue.offer(weight);
        }
        
        while (queue.size() > 1) {
            int diff = queue.poll() - queue.poll();
            if (diff != 0) {
                queue.offer(diff);
            }
        }
        
        return queue.isEmpty() ? 0 : queue.poll();
    }
}

/*

8 7 4 2 1 1
4 2 1 1 1
2 1 1 1
1 1 1
1
*/