class Solution {
    public int characterReplacement(String s, int k) {
        int[] tab = new int[26];
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < s.length()) {
            ++tab[s.charAt(right) - 'A'];
            ++right;
            
            int max = 0;
            for (int i = 0; i < tab.length; ++i) {
                if (tab[i] > max) {
                    max = tab[i];
                }
            }
            
            if (right - left - max > k) {
                --tab[s.charAt(left) - 'A'];
                ++left;   
            }
            
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}