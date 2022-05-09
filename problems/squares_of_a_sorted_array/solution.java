class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int curr = nums.length - 1;
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[curr--] = leftSquare;
                ++left;
            } else {
                result[curr--] = rightSquare;
                --right;
            }
        } 
        
        return result;
    }
}