class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        
        for (int i = 1; i < n; ++i) {
            int tmp = start + 2 * i;
            result ^= tmp;
        }
        
        return result;
    }
}