class Solution {
    public String reverseVowels(String s) {
        char[] tab = s.toCharArray();
        int left = 0;
        int right = tab.length - 1;
        
        while (left < right) {
            if (!isVowel(tab[left])) {
                ++left;
            } else if (!isVowel(tab[right])) {
                --right;
            } else {
                char tmp = tab[left];
                tab[left] = tab[right];
                tab[right] = tmp;
                ++left;
                --right;
            }
        }
        
        return new String(tab);
    }
    
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A'
            || ch == 'e' || ch == 'E'
            || ch == 'i' || ch == 'I'
            || ch == 'o' || ch == 'O'
            || ch == 'u' || ch == 'U';
    }
}