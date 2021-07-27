class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE - Math.abs(target);
        
        for (int i = 0; i < nums.length - 2; ++i) {
            int sum = findSum(nums, target - nums[i], i + 1, nums.length - 1) + nums[i];
            if (Math.abs(target - result) > Math.abs(target - sum)) {
                result = sum;
            }
        }
        
        return result;
    }
    
    private int findSum(int[] nums, int target, int left, int right) {
        int result = Integer.MAX_VALUE - Math.abs(target);
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                return sum;
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
            
            if (Math.abs(target - result) > Math.abs(target - sum)) {
                result = sum;
            }
        }
        
        return result;
    }
}


// -4 -1 1 2     1
// -1  