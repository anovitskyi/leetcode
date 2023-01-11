class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            if (!Character.isLetterOrDigit(l)) {
                ++left;
                continue;
            }

            char r = s.charAt(right);
            if (!Character.isLetterOrDigit(r)) {
                --right;
                continue;
            }

            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }
}