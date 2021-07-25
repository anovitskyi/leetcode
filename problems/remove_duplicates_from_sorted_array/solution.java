class Solution {
    public int removeDuplicates(int[] nums) {
        int read = 0;
        int write = 0;
        
        while (++read < nums.length) {
            if (nums[read] != nums[write]) {
                nums[++write] = nums[read];
            }
        }
        
        return write + 1;
    }
}