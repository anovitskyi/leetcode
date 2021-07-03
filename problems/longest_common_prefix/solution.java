class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); ++i) {
            int counter = 1;
            for (int j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    break;
                }
                ++counter;
            }
            if (counter == strs.length) {
                builder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }
}