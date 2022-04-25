class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int left, int right) {
        int current = left;
        int last = left;
        int pivot = right;
        
        while (current < pivot) {
            if (nums[current] >= nums[pivot]) {
                int tmp = nums[current];
                nums[current] = nums[last];
                nums[last] = tmp;
                ++last;
            }
            ++current;
        }
        
        if (nums[last] < nums[pivot]) {
            int tmp = nums[pivot];
            nums[pivot] = nums[last];
            nums[last] = tmp;   
        }
        
        if (last == k) {
            return nums[last];
        } else if (last < k) {
            return quickSelect(nums, k, last + 1, right);
        } else {
            return quickSelect(nums, k, left, last - 1);
        }
    }
}

/*
    [5,6,4,3,2,1]
    

*/