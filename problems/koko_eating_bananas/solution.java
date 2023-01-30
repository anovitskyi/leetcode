class Solution {
    public int minEatingSpeed(int[] piles, long h) {
        int left = 1;
        int right = -1;
        int result = -1;
        for (int i = 0; i < piles.length; ++i) {
            if (piles[i] > right) {
                right = piles[i];
            }
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long midTime = calculateTime(piles, mid);

            if (midTime <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private long calculateTime(int[] piles, int pace) {
        long result = 0;

        for (int i = 0; i < piles.length; ++i) {
            result += piles[i] / pace;
            result += piles[i] % pace > 0 ? 1 : 0;
        }

        return result;
    }
}