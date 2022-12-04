class Solution {
    public int minimumAverageDifference(int[] nums) {
        long[] left = new long[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            left[i] = nums[i] + left[i - 1];
        }

        long[] right = new long[nums.length];
        right[0] = left[left.length - 1];
        for (int i = 1; i < nums.length; ++i) {
            right[i] = right[i - 1] - nums[i - 1];
        }

        int result = Integer.MAX_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < nums.length - 1; ++i) {
            long leftAverage = left[i] / (i + 1);
            long rightAverage = (right[i] - nums[i]) / (nums.length - i - 1);
            int absoluteAverage = (int) Math.abs(leftAverage - rightAverage);

            if (result > absoluteAverage) {
                result = absoluteAverage;
                resultIndex = i;
            }
        }

        int absoluteAverage = (int) (left[left.length - 1] / left.length);
        if (result > absoluteAverage) {
            return left.length - 1;
        }
        return resultIndex;
    }
}

/**

    nums =  [2,  5,  3,  9,  5,  3]
    left =  [2,  7,  10, 19, 24, 27]
    right = [27, 25, 20, 17, 8,  3]


 */