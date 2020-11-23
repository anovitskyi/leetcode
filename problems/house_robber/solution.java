class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prevprev = nums[0];
        int prev = Math.max(prevprev, nums[1]);
        
        for (int i = 2; i < nums.length; ++i) {
            int max = Math.max(prev, nums[i] + prevprev);
            prevprev = prev;
            prev = max;
        }
        
        return prev;
    }
}