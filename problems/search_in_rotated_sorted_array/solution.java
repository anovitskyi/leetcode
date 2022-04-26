class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int peak = findPeakIndex(nums, left, right);
        
        if (nums.length > 1 && nums[peak] > nums[peak + 1]) {
            if (target <= nums[right]) {
                left = peak + 1;
            } else {
                right = peak;
            }
        }
        
        return binarySearch(nums, target, left, right);
    }
    
    private int findPeakIndex(int[] nums, int left, int right) {
        while (left < right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] > nums[middle + 1]) {
                return middle;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        
        return right;
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
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