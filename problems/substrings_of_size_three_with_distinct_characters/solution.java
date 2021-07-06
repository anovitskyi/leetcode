class Solution {
    public int countGoodSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 2; ++i) {
            boolean firstAndSecondDistinct = s.charAt(i) != s.charAt(i + 1);
            boolean secondAndThirdDistinct = s.charAt(i + 1) != s.charAt(i + 2);
            boolean firstAndThirdDistinct = s.charAt(i) != s.charAt(i + 2);
            if (firstAndSecondDistinct && secondAndThirdDistinct && firstAndThirdDistinct) {
                ++result;
            }
        }
        return result;
    }
}