class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int base = 26;
        long sourceHash = 0;
        long targetHash = 0;
        for (int i = 0; i < needle.length(); ++i) {
            long basePow = (long) Math.pow(base, i);
            sourceHash += basePow * haystack.charAt(i);
            targetHash += basePow * needle.charAt(i);
        }

        for (int i = needle.length(); i <= haystack.length(); ++i) {
            if (sourceHash == targetHash) {
                int matches = 0;
                for (int j = 0; j < needle.length(); ++j) {
                    if (needle.charAt(j) != haystack.charAt(i - needle.length() + j)) {
                        break;
                    }
                    ++matches;
                }
                if (matches == needle.length()) {
                    return i - needle.length();
                }
            }

            if (i == haystack.length()) {
                break;
            }

            sourceHash -= haystack.charAt(i - needle.length());
            sourceHash /= 26;
            sourceHash += ((long) Math.pow(base, needle.length() - 1)) * haystack.charAt(i);
        }

        return -1;
    }
}