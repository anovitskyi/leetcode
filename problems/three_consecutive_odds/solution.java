class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        for (int i = 0; i <= arr.length - 3; ++i) {
            if (arr[i] % 2 == 0) {
                continue;
            }
            
            if (arr[i + 1] % 2 == 0) {
                ++i;
                continue;
            }
            
            if (arr[i + 2] % 2 == 0) {
                i += 2;
                continue;
            }
            
            return true;
        }
        
        return false;
    }
}