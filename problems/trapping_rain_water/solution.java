class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < left.length; ++i) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; --i) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int leftMax = left[i - 1];
            int rightMax = right[i + 1];
            int min = Math.min(leftMax, rightMax);

            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }
}