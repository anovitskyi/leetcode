class Solution {
    public int climbStairs(int n) {
        int prevprev = 0;
        int prev = 1;
        
        for (int i = 1; i <= n; ++i) {
            int tmp = prev;
            prev = prev + prevprev;
            prevprev = tmp;
        }
        
        return prev;
    }
}