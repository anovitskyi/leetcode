class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int copy = x;
        while (copy > 0) {
            result = result * 10 + copy % 10;
            copy /= 10;
        }
        return x == result;
    }
}