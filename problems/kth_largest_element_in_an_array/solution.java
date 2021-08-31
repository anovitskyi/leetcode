class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, k - 1, 0, nums.length - 1);
        return nums[k - 1];
    }
    
    private void quickSelect(int[] nums, int k, int left, int right) {
        int last = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] > nums[right]) {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
                ++last;
            }
        }
        
        if (nums[last] < nums[right]) {
            int tmp = nums[last];
            nums[last] = nums[right];
            nums[right] = tmp;
        }
        
        if (last == k) {
            return;
        } else if (last > k && left < last - 1) {
            quickSelect(nums, k, left, last - 1);
        } else if (last + 1 < right) {
            quickSelect(nums, k, last + 1, right);
        }
    }
}