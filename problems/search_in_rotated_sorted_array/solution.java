class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            return findTarget(nums, target, 0, nums.length - 1);
        }
        
        int pivot = findPivotIndex(nums);
        if (nums[0] <= target) {
            return findTarget(nums, target, 0, pivot - 1);
        } else {
            return findTarget(nums, target, pivot, nums.length - 1);
        }
    }
    
    private int findPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        
        while (left <= right) {
            middle = (right - left) / 2 + left;
            
            if (middle + 1 < nums.length && nums[middle] > nums[middle + 1]) {
                return middle + 1;
            } else if (middle - 1 >= 0 && nums[middle] < nums[middle - 1]) {
                return middle;
            } else if (nums[middle] > nums[0]) {
                left = middle + 1;
            } else if (nums[middle] < nums[0]) {
                right = middle - 1;
            }
        }
        
        return -1;
    }
    
    private int findTarget(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return -1;
    }
}