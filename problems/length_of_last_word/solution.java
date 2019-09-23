class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean wasLetter = false;
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] == ' ' && wasLetter) {
                return result;
            }

            if (chars[i] != ' ') {
                ++result;
                wasLetter = true;
            }
        }

        return result;
    }
}