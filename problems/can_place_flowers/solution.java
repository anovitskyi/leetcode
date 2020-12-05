class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }
        
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) {
                continue;
            }
            
            int left = i - 1 >= 0 ? flowerbed[i - 1] : 0;
            int right = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
            
            if (left == 1 || right == 1) {
                continue;
            }
            
            flowerbed[i] = 1;
            if (--n == 0) {
                return true;
            }
        }
        
        return false;
    }
}