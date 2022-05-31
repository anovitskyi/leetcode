class Solution {
    public int rob(int[] nums) {
        if (nums.length > 1) {
            nums[1] = Math.max(nums[0], nums[1]);
        }
        
        for (int i = 2; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);    
        }
        
        return nums[nums.length - 1];
    }
}

/*
    
    [10,2,3,10]
    [10, 10, 13, 20]


*/