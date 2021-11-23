class Solution {
    public void sortColors(int[] nums) {
        int white = 0;
        int blue = 0;
        int index = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[index++] = 0;
            } else if (nums[i] == 1) {
                ++white;
            } else if (nums[i] == 2) {
                ++blue;
            }
        }
        
        while (white-- > 0) {
            nums[index++] = 1;
        }
        
        while (blue-- > 0) {
            nums[index++] = 2;
        }
    }
}