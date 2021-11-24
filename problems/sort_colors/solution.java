class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                ++index;
                ++left;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                --right;
            } else {
                ++index;
            }
        }
    }
    
    private void swap(int[] nums, int f, int s) {
        int tmp = nums[f];
        nums[f] = nums[s];
        nums[s] = tmp;
    }
}