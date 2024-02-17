class Solution {
    public int tribonacci(int n) {
        int prevprev = 0;
        if (n == 0) {
            return prevprev;
        }

        int prev = 1;
        if (n == 1) {
            return prev;
        }

        int curr = 1;
        if (n == 2) {
            return curr;
        }

        for (int i = 3; i <= n; ++i) {
            int sum = prevprev + prev + curr;
            prevprev = prev;
            prev = curr;
            curr = sum;
        }

        return curr;
    }
}