class Solution {
    public int characterReplacement(String s, int k) {
        int[] tab = new int[26];
        int result = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            ++tab[s.charAt(right) - 'A'];
            ++right;
            
            int max = 0;
            for (int counter : tab) {
                if (counter > max) {
                    max = counter;
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