class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        int maxIndex = findMaxIndex(nums);
        if (maxIndex != -1) {
            if (target <= nums[right]) {
                left = maxIndex + 1;
            } else {
                right = maxIndex;
            }
        }
        
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
    
    private int findMaxIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] > nums[nums.length - 1]) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return result;
    }
}

// 100 1 2 3 4 5