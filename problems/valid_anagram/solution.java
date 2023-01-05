class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] tab = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++tab[s.charAt(i) - 'a'];
            --tab[t.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            if (tab[i] != 0) {
                return false;
            }
        }
        return true;
    }
}