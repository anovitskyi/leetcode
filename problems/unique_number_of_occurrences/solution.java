class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(1000);
        for (int num : arr) {
            int quantity = map.getOrDefault(num, 0);
            map.put(num, quantity + 1);
        }
        
        Set<Integer> set = new HashSet<>(map.size());
        for (int quantity : map.values()) {
            if (!set.add(quantity)) {
                return false;
            }
        }
        return true;
    }
}