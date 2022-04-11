class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] prefixSum = new long[nums.length];
        long prev = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum[i] = nums[i] + prev;
            prev = prefixSum[i];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result[i] = -1;
        }
        
        int windowSize = k * 2 + 1;
        for (int i = windowSize - 1; i < nums.length; ++i) {
            long c = prefixSum[i];
            long p = i - windowSize < 0 ? 0L : prefixSum[i - windowSize];
            
            int avg = (int) ((c - p) / windowSize);
            result[i - k] = avg;
        }
        return result;
    }
}

/*

 0  1   2   3   4   5   6   7   8
[7, 4,  3,  9,  1,  8,  5,  2,  6]
[7, 11, 14, 23, 24, 32, 37, 39, 45]

*/