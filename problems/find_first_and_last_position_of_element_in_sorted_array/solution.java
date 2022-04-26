class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            binarySearch(nums, target, -1),
            binarySearch(nums, target, 1)
        };
    }
    
    private int binarySearch(int[] nums, int target, int direction) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] == target) {
                result = middle;
                if (direction == -1) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return result;
    }
}