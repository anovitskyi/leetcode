class Solution {
    
    public int fib(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        
        int prev = 1;
        int sum = 1;
        
        for (int i = 3; i <= N; ++i) {
            int tmp = sum + prev;
            prev = sum;
            sum = tmp;
        }
        
        return sum;
        
    }
}