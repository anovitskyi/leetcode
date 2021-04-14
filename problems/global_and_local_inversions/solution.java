class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int prev = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] < -1) {
                return false;
            }
            
            if (nums[i] < nums[i - 1] && nums[i] < prev) {
                return false;
            } else {
                prev = nums[i - 1];
            }
        }
        
        
        return true;
    }
}