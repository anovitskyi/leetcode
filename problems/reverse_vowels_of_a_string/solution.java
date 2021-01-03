class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        char[] tab = s.toCharArray(); // h e l l o
        while (left < right) {
            while (left < s.length() && !isVowel(tab[left])) {
                ++left;
            }
            while (right >= 0 && !isVowel(tab[right])) {
                --right;
            }
            
            if (left < right) {
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
        if (ch < 'a') {
            ch += 32;
        }
        
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
     }
}