class Solution {
    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int newValue = (nums[nums[i]] & 0xffff) << 16;
            nums[i] = nums[i] | newValue;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] >>> 16;
        }
        
        return nums;
    }
}