class Solution {
    public int numIdenticalPairs(int[] nums) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int i = nums.length - 1; i >= 0; --i) {
            int tmp = map.getOrDefault(nums[i], 0);
            counter += tmp;
            map.put(nums[i], tmp + 1);
        }
        
        return counter;
    }
}