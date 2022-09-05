class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (char task : tasks) {
            int next = map.getOrDefault(task, 0 - n - 1) + n + 1;
            queue.offer(next);
            map.put(task, next);
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

/*

    ["A","A","A","B","B","B"]
    
    8                         |
    queue = [0, 0, 3, 3, 6, 6]
    map = {
        'A': 6,
        'B': 6
    }


*/