class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        while (--k >= 0) {
            result[k] = queue.poll();
        }
        return result;
    }
}