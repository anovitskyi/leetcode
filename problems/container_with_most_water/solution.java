class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxCapacity = 0;
        
        while (left < right) {
            int currCapacity = Math.min(height[left], height[right]) * (right - left);
            maxCapacity = Math.max(maxCapacity, currCapacity);
            
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        
        return maxCapacity;
    }
}