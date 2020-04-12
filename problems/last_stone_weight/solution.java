class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; ++i) {
            queue.add(stones[i]);
        }
        
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            
            if (x != y) {
                queue.add(x - y);
            }
        }
        
        return queue.isEmpty() ? 0 : queue.poll();
    }
}