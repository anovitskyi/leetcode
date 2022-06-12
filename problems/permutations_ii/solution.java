class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(map, result, new ArrayList<>(), nums.length);
        return result;
    }
    
    private void backtrack(Map<Integer, Integer> map, List<List<Integer>> result, List<Integer> curr, int targetLength) {
        if (curr.size() == targetLength) {
            result.add(curr);
            return;
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 0) {
                continue;
            }
            
            map.put(key, val - 1);
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(key);
            backtrack(map, result, copy, targetLength);
            map.put(key, val);
        }
    }
}