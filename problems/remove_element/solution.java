class Solution {
    public int removeElement(int[] nums, int val) {
        int write = -1;
        int read = 0;
        
        while (read < nums.length) {
            if (nums[read] != val) {
                nums[++write] = nums[read];
            }
            ++read;
        }
        
        return write + 1; 
    }
}