class Solution {
    public int climbStairs(int n) {
        int prevprev = 0;
        int prev = 1;
        
        while (n-- > 0) {
            int sum = prevprev + prev;
            prevprev = prev;
            prev = sum;
        }
        
        return prev;
    }
}