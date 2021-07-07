class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        
        int result = 0;
        int index = -1;
        int[] tab = new int[26];
        ++tab[s.charAt(++index) - 'a'];
        ++tab[s.charAt(++index) - 'a'];
        
        while (++index < s.length()) {
            ++tab[s.charAt(index) - 'a'];
            if (tab[s.charAt(index) - 'a'] == 1 && tab[s.charAt(index - 1) - 'a'] == 1) {
                ++result;
            }
            --tab[s.charAt(index - 2) - 'a'];
        }
        
        return result;
    }
}