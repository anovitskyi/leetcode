class Solution {
    public String reverseStr(String s, int k) {
        char[] tab = s.toCharArray();
        
        for (int i = 0; i < tab.length; i += 2 * k) {
            int left = i;
            int right = Math.min(left + k, tab.length);
            int diff = right - left;
            
            for (int pos = 0; pos < diff / 2; ++pos) {
                char tmp = tab[left + pos];
                tab[left + pos] = tab[right - pos - 1];
                tab[right - pos - 1] = tmp;
            }
        }
        
        return new String(tab);
    }
}