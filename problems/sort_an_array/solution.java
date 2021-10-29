class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = right;
        int lastGreater = left;
        for (int i = left; i < pivot; ++i) {
            if (nums[i] < nums[pivot]) {
                int tmp = nums[i];
                nums[i] = nums[lastGreater];
                nums[lastGreater] = tmp;
                lastGreater++;
            }
        }
        
        if (nums[pivot] < nums[lastGreater]) {
            int tmp = nums[pivot];
            nums[pivot] = nums[lastGreater];
            nums[lastGreater] = tmp;
            pivot = lastGreater;
        }
        
        sort(nums, left, lastGreater - 1);
        sort(nums, lastGreater + 1, right);
    }
}