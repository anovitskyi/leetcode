class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int i = 0; i < nums.length; ++i) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] {i, index};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return null;
    }
}