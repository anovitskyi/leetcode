class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        int left = 0;
        int right = nums.length - 1;
        
        if (pivot != right) {
            if (target <= nums[right]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        
        return findNumber(nums, target, left, right);
    }
    
    private int findPivot(int[] nums, int left, int right) {
        int result = right;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            
            if (mid < result && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private int findNumber(int[] nums, int num, int left, int right) {
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}