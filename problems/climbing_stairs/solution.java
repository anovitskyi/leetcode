class Solution {
    public int climbStairs(int n) {
        int prevprev = 1;
        int prev = 1;

        for (int i = 2; i <= n; ++i) {
            int newStep = prev + prevprev;
            prevprev = prev;
            prev = newStep;
        }

        return prev;
    }
}