class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        Queue<String> queue = new PriorityQueue<>((a, b) -> {
            int diff = map.get(a) - map.get(b);
            
            if (diff == 0) {
                return b.compareTo(a);
            }
            
            return diff;
        });
        
        for (String str : map.keySet()) {
            queue.offer(str);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        LinkedList<String> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.addFirst(queue.poll());
        }
        return result;
    }
}