class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        
        int left = 0;
        int right = x;
        
        while (right - left > 1) {
            int middle = ((right - left) / 2) + left;
            
            if (isPotentialSquareRoot(middle, x)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        
        return left;
    }
    
    private boolean isPotentialSquareRoot(int num, int x) {
        return num <= (x / num);
    }
}