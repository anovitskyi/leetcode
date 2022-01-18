class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        
        for (int i = 0; i < flowerbed.length; ++i) {
            if ((i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0) && flowerbed[i] == 0) {
                --n;
                flowerbed[i] = 1;
            }
            
            if (n == 0) {
                return true;
            }
        }
        
        return false;
    }
}