class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[left] > nums[right]) {
            int pivot = findPivot(nums, left, right);
            if (target <= nums[right]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int findPivot(int[] nums, int left, int right) {
        int lastPivotIndex = left;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[nums.length - 1]) {
                lastPivotIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastPivotIndex;
    }
}