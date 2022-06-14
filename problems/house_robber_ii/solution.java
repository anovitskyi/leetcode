class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int left, int right) {
        int prevprev = nums[left];
        int prev = Math.max(prevprev, nums[left + 1]);
        
        for (int i = left + 2; i <= right; ++i) {
            int tmp = Math.max(prev, nums[i] + prevprev);
            prevprev = prev;
            prev = tmp;
        }
        
        return prev;
    }
}