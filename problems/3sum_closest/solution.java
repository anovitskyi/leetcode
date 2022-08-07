class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE - Math.abs(target);
        for (int i = 0; i < nums.length - 2; ++i) {
            int currSum = findSum(nums, i + 1, nums.length - 1, target - nums[i]) + nums[i];
            
            if (Math.abs(target - currSum) < Math.abs(target - min)) {
                min = currSum;
            }
        }
        
        return min;
    }
    
    private int findSum(int[] nums, int left, int right, int target) {
        int result = Integer.MAX_VALUE - Math.abs(target);
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (Math.abs(target - sum) < Math.abs(target - result)) {
                result = sum;
            }
            
            if (sum == target) {
                break;
            } else if (sum > target) {
                --right;
            } else {
                ++left;
            }
        }
        
        return result;
    }
}