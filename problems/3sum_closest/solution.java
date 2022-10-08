class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = Integer.MAX_VALUE - Math.abs(target);
        for (int i = 0; i < nums.length - 2; ++i) {
            int sum = findTarget(nums, i + 1, nums.length - 1, target - nums[i]) + nums[i];
            
            if (sum == target) {
                return target;
            }
            
            if (Math.abs(sum - target) < Math.abs(result - target)) {
                result = sum;
            }
        }
        
        return result;
    }
    
    private int findTarget(int[] nums, int left, int right, int target) {
        int result = nums[left] + nums[right];
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                return sum;
            }
            
            if (Math.abs(sum - target) < Math.abs(result - target)) {
                result = sum;
            }
            
            if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        
        return result;
    }
}