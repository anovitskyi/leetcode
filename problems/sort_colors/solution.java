class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        
        for (int num : nums) {
            ++colors[num];
        }
        
        int index = 0;
        for (int i = 0; i < colors[0]; ++i) {
            nums[index++] = 0;
        }
        
        for (int i = 0; i < colors[1]; ++i) {
            nums[index++] = 1;
        }
        
        for (int i = 0; i < colors[2]; ++i) {
            nums[index++] = 2;
        }
    }
}