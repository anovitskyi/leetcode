class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            expectedSum += i + 1;
            currSum += nums[i];
        }

        return expectedSum - currSum;
    }
}