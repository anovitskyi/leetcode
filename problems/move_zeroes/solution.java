class Solution {
    public void moveZeroes(int[] nums) {
        int read = 0;
        int write = 0;
        while (read < nums.length) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
            ++read;
        }
        
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }
}