class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            int result = 0;
            while (nums[i] >= 0) {
                ++result;
                int tmp = nums[i];
                nums[i] = -1;
                i = tmp;
            }
            res = Math.max(res, result);
        }
        
        return res;
    }
}