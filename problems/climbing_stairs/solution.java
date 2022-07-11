class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prevprev = 0;
        
        for (int i = 1; i <= n; ++i) {
            int sum = prev + prevprev;
            prevprev = prev;
            prev = sum;
        }
        
        return prev;
    }
}

// 5
