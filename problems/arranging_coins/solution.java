class Solution {
    public int arrangeCoins(int n) {
        int result = 0;
        int tmp = 1;
        while (true) {
            n -= tmp;
            ++tmp;
            if (n >= 0) {
                 ++result;   
            } else {
                break;
            }
        }
        return result;
    }
}