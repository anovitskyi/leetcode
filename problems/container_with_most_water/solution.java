class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int length = right - left;
            int currArea = minHeight * length;

            if (currArea > result) {
                result = currArea;
            }

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}