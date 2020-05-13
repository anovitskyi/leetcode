class Solution {
    public boolean isPerfectSquare(int num) {
        if (num > 0 && num <= 2) {
            return true;
        }
        
        int start = 2;
        int end = num / 2;
        
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int div = num / middle;
            int mod = num % middle;
            
            if (div == middle && mod == 0) {
                return true;
            } else if (div > middle) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        
        return false;
    }
}