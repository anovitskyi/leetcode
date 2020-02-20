class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        
        while (n > 0) {
            int last = n % 10;
            prod *= last;
            sum += last;
            
            n /= 10;
        }
        
        return prod - sum;
    }
}