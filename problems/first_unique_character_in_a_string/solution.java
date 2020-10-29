class Solution {
    public int firstUniqChar(String s) {
        int[] tab = new int[26];
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; ++i) {
            ++tab[charr[i] - 'a'];
        }
        
        for (int i = 0; i < charr.length; ++i) {
            if (tab[charr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}