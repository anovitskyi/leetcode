class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int start, int end) {
        int pivot = end;
        int read = start;
        for (int i = start; i < pivot; ++i) {
            if (nums[i] >= nums[pivot]) {
                int tmp = nums[read];
                nums[read] = nums[i];
                nums[i] = tmp;
                ++read;
            }
        }
        
        if (nums[read] <= nums[pivot]) {
            int tmp = nums[pivot];
            nums[pivot] = nums[read];
            nums[read] = tmp;
            pivot = read;
        }
        
        if (pivot + 1 == k) {
            return nums[pivot];
        } else if (pivot + 1 > k) {
            return quickSelect(nums, k, start, pivot - 1);
        } else {
            return quickSelect(nums, k, pivot + 1, end);
        }
    }
}