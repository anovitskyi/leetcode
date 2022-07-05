class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(findMaxAmount(nums, 0, nums.length - 2), findMaxAmount(nums, 1, nums.length - 1));
    }
    
    private int findMaxAmount(int[] nums, int start, int end) {
        int prevprev = 0;
        int prev = nums[start];
        
        for (int i = start + 1; i <= end; ++i) {
            int tmp = prev;
            prev = Math.max(nums[i] + prevprev, prev);
            prevprev = tmp;
        }
        
        return prev;
    }
}

/*
     |
[1,2,3,1]

prevprev = 2
prev = 4
tmp = 2


*/