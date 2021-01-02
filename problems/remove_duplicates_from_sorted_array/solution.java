class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        
        int write = 0;
        for (int read = 1; read < nums.length; ++read) {
            if (nums[write] != nums[read]) {
                nums[++write] = nums[read];
            }
        }
        return write + 1;
    }
}