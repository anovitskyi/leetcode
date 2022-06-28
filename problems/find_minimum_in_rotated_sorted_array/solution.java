class Solution {
    public int findMin(int[] nums) {
        int peakIndex = findPeak(nums);
        
        if (peakIndex == -1) {
            return nums[0];
        }
        
        return nums[peakIndex + 1];
    }
    
    private int findPeak(int[] nums) {
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