class Solution {
    public int longestSubstring(String s, int k) {
        return divideAndConqure(s, k, 0, s.length() - 1);
    }
    
    private int divideAndConqure(String s, int k, int left, int right) {
        int currLength = right - left + 1;
        
        if (currLength < k) {
            return 0;
        }
        
        int[] cache = new int[26];
        for (int i = left; i <= right; ++i) {
            int index = s.charAt(i) - 'a';
            ++cache[index];
        }
        
        for (int i = left; i <= right; ++i) {
            int index = s.charAt(i) - 'a';
            if (cache[index] < k) {
                int l = divideAndConqure(s, k, left, i - 1);
                int r = divideAndConqure(s, k, i + 1, right);
                return Math.max(l, r);
            }
        }
        
        return currLength;
    }
}