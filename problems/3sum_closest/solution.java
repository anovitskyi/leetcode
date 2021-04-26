class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = target + Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int twoSum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; ++k) {
                    int threeSum = twoSum + nums[k];
                    if (threeSum == target) {
                        return target;
                    }
                    if (Math.abs(target - threeSum) < Math.abs(target - result)) {
                        result = threeSum;
                    }
                }
            }
        }
        
        return result;
    }
}