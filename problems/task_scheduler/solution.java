class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (char task : tasks) {
            int newTime = map.getOrDefault(task, 0 - n  - 1) + n + 1;
            map.put(task, newTime);
            queue.offer(newTime);
        }
        
        int result = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() <= result) {
                queue.poll();
            }
            
            ++result;
        }
        return result;
    }   
}