class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diffs = new int[capacity.length];
        for (int i = 0; i < capacity.length; ++i) {
            diffs[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diffs);

        int result = 0;
        for (int i = 0; i < capacity.length; ++i) {
            if (diffs[i] > additionalRocks) {
                break;
            }

            additionalRocks -= diffs[i];
            ++result;
        }
        return result;
    }
}