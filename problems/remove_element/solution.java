class Solution {
    public int removeElement(int[] nums, int val) {
        int read = 0;
        int write = 0;
        
        while (read < nums.length) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                ++write;
            }
            ++read;
        }
        
        return write;
    }
}