class Solution {
    public int minSteps(String s, String t) {
        int[] tab = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++tab[s.charAt(i) - 'a'];
            --tab[t.charAt(i) - 'a'];
        }
        
        int result = 0;
        for (int i = 0; i < 26; ++i) {
            if (tab[i] > 0) {
                result += tab[i];
            }
        }
        return result;
    }
}