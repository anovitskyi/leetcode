class Solution {
    public int maxPower(String s) {
        int result = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++curr;
            } else {
                result = Math.max(result, curr);
                curr = 1;
            }
        }
        return Math.max(result, curr);
    }
}