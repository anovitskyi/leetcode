class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int curr = sum;
        for (int i = 1; i < nums.length; ++i) {
            if (curr < 0) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }
            
            sum = Math.max(curr, sum);
        }
        return sum;
    }
}