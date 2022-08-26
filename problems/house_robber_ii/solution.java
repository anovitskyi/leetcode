class Solution {
    public int rob(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        if (left == right) {
            return nums[left];
        }
        
        return Math.max(rob(nums, left, right - 1), rob(nums, left + 1, right));
    }
    
    private int rob(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int prevprev = nums[left];
        int prev = Math.max(nums[left], nums[++left]);
        
        while (++left <= right) {
            int tmp = prev;
            prev = Math.max(nums[left] + prevprev, prev);
            prevprev = tmp;
        }
        return prev;
    }
}