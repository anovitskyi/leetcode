class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] tab = new int[26];
        char[] stab = s.toCharArray();
        char[] ttab = t.toCharArray();
        
        for (int i = 0; i < stab.length; ++i) {
            ++tab[stab[i] - 'a'];
            --tab[ttab[i] - 'a'];
        }
        
        for (int i = 0; i < 26; ++i) {
            if (tab[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}