class Solution {
    public int[] sortedSquares(int[] nums) {
        int lastNegative = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                lastNegative = i;
            }
            
            nums[i] = nums[i] * nums[i];
        }
        
        if (lastNegative == -1) {
            return nums;
        }
        
        int firstPositive = lastNegative + 1;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (lastNegative < 0) {
                copy[i] = nums[firstPositive++];
                continue;
            }
            
            if (firstPositive >= nums.length) {
                copy[i] = nums[lastNegative--];
                continue;
            }
            
            if (nums[lastNegative] < nums[firstPositive]) {
                copy[i] = nums[lastNegative--];
            } else {
                copy[i] = nums[firstPositive++];
            }
        }
        return copy;
    }
}