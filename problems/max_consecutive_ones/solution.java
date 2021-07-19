class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int currResult = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                result = Math.max(result, currResult);
                currResult = 0;
            } else {
                ++currResult;
            }
        }
        
        return Math.max(result, currResult);
    }
}