class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int last = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
                ++last;
            }
        }
        
        return nums;
    }
}