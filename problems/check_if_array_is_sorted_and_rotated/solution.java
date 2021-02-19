class Solution {
    public boolean check(int[] nums) {
        boolean shouldBeDividor = nums[0] >= nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (shouldBeDividor) {
                    shouldBeDividor = !shouldBeDividor;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}