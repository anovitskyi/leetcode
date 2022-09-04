class Solution {
    public int maxSubArray(int[] nums) {
        int right = 1;
        int result = nums[0];
        int sum = nums[0];
        
        while (right < nums.length) {
            if (sum < 0) {
                sum = 0;
            }
            
            sum += nums[right];
            result = Math.max(sum, result);
            ++right;
        }
        
        return result;
    }
}