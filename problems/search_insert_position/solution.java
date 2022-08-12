class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = nums.length;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        
        return result;
    }
}