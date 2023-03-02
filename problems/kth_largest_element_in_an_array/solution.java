class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int write = start;
        int read = start;
        while (read < end) {
            if (nums[read] >= nums[end]) {
                int tmp = nums[write];
                nums[write] = nums[read];
                nums[read] = tmp;
                ++write;
            }

            ++read;
        }

        int tmp = nums[write];
        nums[write] = nums[end];
        nums[end] = tmp;

        if (write == k) {
            return nums[write];
        } else if (k > write) {
            return quickSelect(nums, k, write + 1, end);
        } else {
            return quickSelect(nums, k, start, write - 1);
        }
    }
}