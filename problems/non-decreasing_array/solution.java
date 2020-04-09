class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean enough = false;
        
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (enough) {
                    return false;
                }
                enough = true;
                
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        
        return true;
    }
}