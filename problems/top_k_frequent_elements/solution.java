class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new LinkedList<>();
            }
            
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        int[] result = new int[k];
        for (int i = buckets.length - 1; k >= 0 && i >= 0; --i) {
            List<Integer> elements = buckets[i];
            if (elements == null || elements.isEmpty()) {
                continue;
            }
            
            Iterator<Integer> iter = elements.iterator();
            while (k > 0 && iter.hasNext()) {
                result[--k] = iter.next();
            }
        }
        return result;
    }
}