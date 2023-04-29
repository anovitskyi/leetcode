class Solution {
    public int rob(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int prev = i - 1 >= 0 ? nums[i - 1] : 0;
            int prevprev = i - 2 >= 0 ? nums[i - 2] : 0;

            nums[i] = Math.max(prev, nums[i] + prevprev);
        }

        return nums[nums.length - 1];
    }
}