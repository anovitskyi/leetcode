class Solution {
    public int jump(int[] nums) {
        nums[nums.length - 1] = 0;
        
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] == 0) {
                continue;
            } else if (nums[i] + i >= nums.length - 1) {
                nums[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                
                for (int j = i + 1; j <= i + nums[i]; ++j) {
                    if (nums[j] > 0 && nums[j] < min) {
                        min = nums[j];
                    }
                }
                
                nums[i] = min == Integer.MAX_VALUE ? 0 : min + 1;
            }
        }
        
        return nums[0];
    }
}