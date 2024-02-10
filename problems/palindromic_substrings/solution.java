class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            result += countPalindrome(s, i, i);
            result += countPalindrome(s, i, i + 1);
        }

        return result;
    }

    private int countPalindrome(String s, int left, int right) {
        int result = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++result;
            --left;
            ++right;
        }

        return result;
    }
}