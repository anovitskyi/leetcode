class Solution {
    public int maxArea(int[] height) {
        int max = -1;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int container = minHeight * (right - left);
            max = Math.max(max, container);
            
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        
        return max;
    }
}