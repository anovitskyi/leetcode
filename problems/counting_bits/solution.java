class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            result[i] = count(i);
        }
        return result;
    }
    
    private int count(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 2;
            num /= 2;
        }
        return res;
    }
}