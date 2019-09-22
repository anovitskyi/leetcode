class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        char[] chars = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            point:
            if (chars[i] == needles[0] && i + needles.length <= chars.length) {
                for (int m = 1, n = i + 1; m < needles.length; ++m, ++n) {
                    if (chars[n] != needles[m]) {
                        break point;
                    }
                }
                return i;
            }
        }

        return -1;

    }
}