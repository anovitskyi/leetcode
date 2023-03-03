class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < tasks.length; ++i) {
            char task = tasks[i];
            int time = map.getOrDefault(task, 0 - n - 1) + n + 1; 

            queue.offer(time);
            map.put(task, time);
        }

        int time = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() <= time) {
                queue.poll();
            }
            ++time;
        }
        return time;
    }
}