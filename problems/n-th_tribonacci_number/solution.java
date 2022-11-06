class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        int prev = 1;
        int prevprev = 1;
        int prevprevprev = 0;

        for (int i = 3; i <= n; ++i) {
            int sum = prev + prevprev + prevprevprev;
            prevprevprev = prevprev;
            prevprev = prev;
            prev = sum;
        }

        return prev;
    }
}