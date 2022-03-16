class Solution {
    public int firstUniqChar(String s) {
        int[] cache = new int[26];
        char[] tab = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            ++cache[tab[i] - 'a'];
        }
        
        for (int i = 0; i < s.length(); ++i) {
            if (cache[tab[i] - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}