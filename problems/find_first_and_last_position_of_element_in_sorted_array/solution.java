class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            findLeftBound(nums, target),
            findRightBound(nums, target)
        };
    }
    
    private int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] == target) {
                result = middle;
                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return result;
    }
    
     private int findRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] == target) {
                result = middle;
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return result;
    }
}