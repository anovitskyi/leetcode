class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int left = nums[0] * nums[1] * nums[nums.length - 1];
        int right = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        
        return Math.max(left, right);
    }
}