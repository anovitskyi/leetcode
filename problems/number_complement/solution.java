class Solution {
    public int findComplement(int num) {
        int result = 0;
        for (int i = 0; num > 0; ++i, num /= 2) {
            int invertedLast = ((num % 2) + 1) % 2;
            result |= (invertedLast << i);
        }
        return result;
    }
}