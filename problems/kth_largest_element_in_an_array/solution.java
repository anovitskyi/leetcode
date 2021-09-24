class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int pivot = nums[right];
        int last = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] > pivot) {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
                ++last;
            }
        }
        
        int tmp = nums[last];
        nums[last] = nums[right];
        nums[right] = tmp;
        
        if (last == k) {
            return nums[k];
        } else if (last > k) {
            return quickSelect(nums, k, left, last - 1);
        } else {
            return quickSelect(nums, k, left + 1, right);
        }
    }
}