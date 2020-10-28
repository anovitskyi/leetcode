class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        
        int res = 0;
        int pow = 1;
        
        while (N > 0) {
            if ((N % 2) - 1 == -1) {
                res += pow;
            }
            pow *= 2;
            N /= 2;
        }
        
        return res;
    }
}