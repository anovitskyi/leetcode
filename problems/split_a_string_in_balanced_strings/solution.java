class Solution {
    public int balancedStringSplit(String s) {
        int counter = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            counter += s.charAt(i) == 'L' ? -1 : 1;
            if (counter == 0) {
                ++result;
            }
        }
        return result;
    }
}