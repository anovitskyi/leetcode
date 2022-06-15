class Solution {
    public int jump(int[] nums) {
        return stepsToReachLastElement(nums, new int[nums.length], 0);
    }
    
    private int stepsToReachLastElement(int[] nums, int[] cache, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        
        if (cache[index] == 0) {
            int min = Integer.MAX_VALUE - 1;
            for (int i = nums[index]; i >= 1; --i) {
                min = Math.min(min, stepsToReachLastElement(nums, cache, index + i));
            }
            cache[index] = min + 1;
        }
        
        return cache[index];
    }
}