class Solution {
    public int fib(int n) {
        int prevprev = 0;
        if (n == 0) {
            return prevprev;
        }
        
        int prev = 1;
        if (n == 1) {
            return prev;
        }
        
        int actualSum = 1; 
        for (int i = 2; i <= n; ++i) { // 5
            actualSum = prevprev + prev; // 5
            prevprev = prev; // 3
            prev = actualSum; // 5
        }
        return prev;
    }
}