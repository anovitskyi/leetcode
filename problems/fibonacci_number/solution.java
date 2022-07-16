class Solution {
    
    public int fib(int n) {
        return tailRecursion(n, 0, 1);
    }
    
    private int tailRecursion(int n, int prevprev, int prev) {
        if (n == 0) {
            return prevprev;
        }
        
        if (n == 1) {
            return prev;
        }
        
        return tailRecursion(n - 1, prev, prev + prevprev);
    }
}