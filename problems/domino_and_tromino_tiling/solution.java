class Solution {
    public int numTilings(int n) {
        int mod = 1_000_000_007;
        long[] result = new long[Math.max(4, n + 1)];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 5;

        for (int i = 4; i <= n; ++i) {
            result[i] = (2 * result[i - 1] + result[i - 3]) % mod;
        }

        return (int) result[n];
    }
}