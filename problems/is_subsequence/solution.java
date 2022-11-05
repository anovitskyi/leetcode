class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int pointer = 0;

        for (int i = 0; i < t.length() && pointer < s.length(); ++i) {
            if (t.charAt(i) == s.charAt(pointer)) {
                ++pointer;
            }
        }

        return pointer == s.length();
    }
}