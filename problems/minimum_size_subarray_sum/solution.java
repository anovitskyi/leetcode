class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (right < nums.length) {
            if (sum < target) {
                sum += nums[right];
                ++right;
            } else {
                result = Math.min(result, right - left);
                sum -= nums[left];
                ++left;
            }
        }
        
        while (sum >= target) {
            result = Math.min(result, right - left);
            sum -= nums[left];
            ++left;
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}