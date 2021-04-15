class Solution {
    
    // recursive
//     public int fib(int n) {
//         if (n == 0) {
//             return 0;
//         }
        
//         if (n == 1) {
//             return 1;
//         }
        
//         return fib(n - 1) + fib(n - 2);
//     }
    
    // dynamic programming
//     private static final int[] cache = new int[31];
    
//     static {
//         for (int i = 2; i < cache.length; ++i) {
//             cache[i] = -1;
//         }
        
//         cache[1] = 1;
//     }
    
//     public int fib(int n) {
//         if (cache[n] != -1) {
//             return cache[n];
//         }
        
//         cache[n] = fib(n - 1) + fib(n - 2);
//         return cache[n];
//     }
    
    // iterative
//     public int fib(int n) {
//         if (n == 0) {
//             return 0;
//         }
        
//         int prev = 1;
//         int prevprev = 0;
        
//         for (int i = 1; i < n; ++i) {
//             int sum = prevprev + prev;
//             prevprev = prev;
//             prev = sum;
//         }
        
//         return prev;
//     }
    
//     // tail recursion
    public int fib(int n) {
        return fibTail(n, 1, 0);
    }
    
    private int fibTail(int n, int prev, int prevprev) {
        if (n == 1) {
            return prev;
        }
        
        if (n == 0) {
            return prevprev;
        }
        
        return fibTail(n - 1, prev + prevprev, prev);
    }
}