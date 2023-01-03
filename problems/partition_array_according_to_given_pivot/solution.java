class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int eq = 0;
        int grt = 0;

        for (int num : nums) {
            if (num < pivot) {
                ++eq;
            } else if (num == pivot) {
                ++grt;
            }
        }

        if (eq > 0) {
            grt += eq;
        }

        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num < pivot) {
                result[less++] = num;
            } else if (num == pivot) {
                result[eq++] = num;
            } else {
                result[grt++] = num;
            }
        }
        return result;
    }
}