class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(findMaxSum(nums, 0, nums.length - 2), findMaxSum(nums, 1, nums.length - 1));
    }
    
    private int findMaxSum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        if (right - left == 1) {
            return Math.max(nums[left], nums[left + 1]);
        }
        
        int prevprev = nums[left];
        int prev = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; ++i) {
            int tmp = prev;
            prev = Math.max(prev, nums[i] + prevprev);
            prevprev = tmp;
        }
        return prev;
    }
}

/*
    
    [1,2,3,1,5,4,3,7]
    
    
     2 3 3 8 8 11 15 
    [2,3,1,5,4,3,7] => 
    ||
    [1,2,3,1,5,4,3]

*/