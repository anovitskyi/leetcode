class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int counter = 0;
        
        for (int i = 0; i < 31; ++i) {
            if (left == right) {
                break;
            }
            
            ++counter;
            left >>= 1;
            right >>= 1;
        }
        
        return left << counter;
    }
}

/*

0101
0110
0111
1000


*/