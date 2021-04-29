class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        
        return new int[] {
            left, right
        };
    }
    
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        int mid = -1;
        while (left <= right) {
            mid = ((right - left) / 2) + left;
            
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        int mid = -1;
        while (left <= right) {
            mid = ((right - left) / 2) + left;
            
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}