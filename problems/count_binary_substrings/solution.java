class Solution {                                
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        
        int result = 0;
        int count = 1;
        int prev = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result += Math.min(prev, count);
                prev = count;
                count = 0;
            }
            ++count;
        }
        return result + Math.min(prev, count);
    }
}