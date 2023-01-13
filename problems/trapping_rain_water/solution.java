class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length - 1; ++i) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
            right[height.length - i - 1] = Math.max(height[height.length - i], right[height.length - i]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int diff = Math.min(left[i], right[i]) - height[i];
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}