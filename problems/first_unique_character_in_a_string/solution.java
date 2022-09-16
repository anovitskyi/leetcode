class Solution {
    public int firstUniqChar(String s) {
        int[] tab = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++tab[s.charAt(i) - 'a'];
        }
        
        for (int i = 0; i < s.length(); ++i) {
            if (tab[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}