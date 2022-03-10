class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] min = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        
        for (int maxIndex = 1, minIndex = nums.length - 2; maxIndex < nums.length; ++maxIndex, --minIndex) {
            max[maxIndex] = Math.max(max[maxIndex - 1], nums[maxIndex]);
            min[minIndex] = Math.min(min[minIndex + 1], nums[minIndex]);
        }
        
        int result = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ++result;
                if (max[i - 1] < nums[i] && nums[i] < min[i + 1]) {
                    ++result;
                }
            }
        }
        return result;
    }
}