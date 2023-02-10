class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int absVal = Math.abs(nums[i]);
            int index = absVal - 1;
            
            if (nums[index] < 0) {
                return absVal;
            }

            nums[index] = 0 - nums[index];
        }

        return -1;
    }
}