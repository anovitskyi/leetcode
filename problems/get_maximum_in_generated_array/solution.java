class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        int result = 1;

        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i / 2];
            if (i % 2 == 1) {
                arr[i] += arr[i / 2 + 1];
            }
            result = Math.max(result, arr[i]);
        }

        return result;
    }
}