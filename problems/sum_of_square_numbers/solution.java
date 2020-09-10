class Solution {
     
    public boolean judgeSquareSum(int c) {
        int limit = (int) (Math.sqrt(c) + 0.5);
        
        for (int i = 0; i <= limit; ++i) {
            int searchNumber = c - (i * i);
            double root = Math.sqrt(searchNumber);
            
            if (root % 1 == 0) {
                return true;
            }
        }
        
        return false;
    }
}