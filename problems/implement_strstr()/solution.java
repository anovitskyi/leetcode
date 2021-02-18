class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        
        int start = 0;
        int end = needle.length();
        int patternHash = hash(needle, end);
        int actualHash = hash(haystack, end);
        
        while (true) {
            if (patternHash == actualHash && haystack.substring(start, end).equals(needle)) {
                return start;
            }
            
            if (end >= haystack.length()) {
                return -1;
            }
            
            actualHash -= (Math.pow(26, 0) * (haystack.charAt(start) - 'a' + 1));
            actualHash /= 26;
            actualHash += (Math.pow(26, needle.length() - 1) * (haystack.charAt(end) - 'a' + 1));
            
            ++start;
            ++end;
        }
    }
    
    private int hash(String text, int end) {
        int result = 0;
        
        for (int i = 0; i < end; ++i) {
            int letter = text.charAt(i) - 'a' + 1;
            result += (Math.pow(26, i) * letter);
        }
        
        return result;
    }
}