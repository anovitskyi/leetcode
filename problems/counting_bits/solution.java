class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        int counter = 0;
        for (int i = 0; i <= n; ++i) {
            ans[i] = countOnes(i);
        }

        return ans;
    }

    private int countOnes(int num) {
        int counter = 0;
        
        while (num > 0) {
            counter += num % 2;
            num /= 2;
        }

        return counter;
    }
}
/**

    6  => 0110
    7  => 0111
    8  => 1000
    9  => 1001
    10 => 1010
    11 => 1011
    12 => 1100
    13 => 1101
    14 => 1110
    15 => 1111

 */