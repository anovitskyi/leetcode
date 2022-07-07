class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            rightSum += nums[i];
        }
        
        int result = -1;
        for (int i = 0; i < nums.length; ++i) {
            rightSum -= nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        return result;
    }
}