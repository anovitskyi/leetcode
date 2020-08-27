class Solution {
    public int maxProduct(int[] nums) {
        int f = Math.max(nums[0], nums[1]);
        int s = Math.min(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] > f) {
                s = f;
                f = nums[i];
            } else if (nums[i] > s) {
                s = nums[i];
            }
        }
        
        return (f - 1) * (s - 1);
    }
}