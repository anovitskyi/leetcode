class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        int size = 0;

        while (size < nums.length) {
            List<Integer> row = new ArrayList<>();
            
            for (int num : map.keySet()) {
                if (map.get(num) > 0) {
                    row.add(num);
                    map.put(num, map.get(num) - 1);
                    ++size;
                }
            }
            
            result.add(row);
        }

        return result;
    }
}