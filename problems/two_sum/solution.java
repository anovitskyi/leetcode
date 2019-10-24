class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>(nums.length);
        
        
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (table.containsKey(diff)) {
                return new int[] {i, table.get(diff)};
            } else {
                 table.put(nums[i], i);
            }
        }

        return null;
    }
}