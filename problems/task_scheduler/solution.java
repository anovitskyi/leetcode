class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int quantity : map.values()) {
            heap.offer(quantity);
        }
        
        while (!heap.isEmpty() || !queue.isEmpty()) {
            if (!heap.isEmpty()) {
                int poll = heap.poll();
                if (poll > 1) {
                    queue.offer(new int[] {poll - 1, time + n});   
                }
            }
            
            if (!queue.isEmpty()) {
                if (queue.peek()[1] <= time) {
                    heap.offer(queue.poll()[0]);
                }
            }
            
            ++time;
        }
            
        return time;
    }
}