class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String shortest = strs[0];

        for (int i = 1; i < strs.length; ++i) {
            if (shortest.length() > strs[i].length()) {
                shortest = strs[i];
            }
        }

        String prefix = null;
        for (int i = shortest.length(); i >= 0; --i) {
            prefix = shortest.substring(0, i);

            boolean allMatch = true;
            for (int j = 0; j < strs.length; ++j) {
                String str = strs[j];
                if (!str.startsWith(prefix)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                return prefix;
            }
        }
        return "";
    }
}