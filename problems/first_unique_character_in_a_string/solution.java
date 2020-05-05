class Solution {
    public int firstUniqChar(String s) {
        int[] elems = new int[26];
        char[] tab = s.toCharArray();
        
        for (int i = 0; i < tab.length; ++i) {
            ++elems[tab[i] - 97];
        }
        
        for (int i = 0; i < tab.length; ++i) {
            if (elems[tab[i] - 97] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}