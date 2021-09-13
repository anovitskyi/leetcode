class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        
        int left = 0;
        int right = x;
        
        while (left < right - 1) {
            int middle = ((right - left) / 2) + left;
            
            if (isPotentialSquareRoot(x, middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        
        return left;
    }
    
    private boolean isPotentialSquareRoot(int x, int num) {
        return num <= (x / num);
    }
}