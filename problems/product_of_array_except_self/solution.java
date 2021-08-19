class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - 1 - i];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            int l = i - 1 < 0 ? 1 : left[i - 1];
            int r = i + 1 >= nums.length ? 1 : right[i + 1];
            
            nums[i] = l * r;
        }
        
        return nums;
    }
}