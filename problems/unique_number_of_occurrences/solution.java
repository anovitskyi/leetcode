class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            int counter = map.getOrDefault(num, 0);
            map.put(num, counter + 1);
        }
        
        Set<Integer> set = new HashSet<>();
        for (Integer val : map.values()) {
            if (!set.add(val)) {
                return false;
            }
        }
        
        return true;
    }
}