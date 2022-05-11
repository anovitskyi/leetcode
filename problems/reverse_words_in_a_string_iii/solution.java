class Solution {
    public String reverseWords(String s) {
        char[] tab = s.toCharArray();
        
        int left = 0;
        int right = 0;
        
        while (right <= s.length()) {
            if (right == s.length() || tab[right] == ' ') {
                reverse(tab, left, right - 1);
                left = right + 1;
            }
            
            ++right;
        }
        
        return new String(tab);
    }
    
    private void reverse(char[] tab, int left, int right) {
        while (left < right) {
            char tmp = tab[left];
            tab[left] = tab[right];
            tab[right] = tmp;
            
            ++left;
            --right;
        }
    }
}