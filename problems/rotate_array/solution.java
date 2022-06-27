class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        
        rotateArray(nums, 0, nums.length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, nums.length - 1);
    }
    
    private void rotateArray(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            
            ++left;
            --right;
        }
    }
}