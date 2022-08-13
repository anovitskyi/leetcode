class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        
        if (k >= nums.length) {
            k = k % nums.length;
        }
        
        rotateInternal(nums, 0, nums.length - 1);
        rotateInternal(nums, 0, k - 1);
        rotateInternal(nums, k, nums.length - 1);
    }
    
    private void rotateInternal(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}