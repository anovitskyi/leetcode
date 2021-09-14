class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        char[] tab = s.toCharArray();
        while (left < right) {
            if (Character.isLetter(tab[left]) && Character.isLetter(tab[right])) {
                char tmp = tab[left];
                tab[left] = tab[right];
                tab[right] = tmp;
                
                ++left;
                --right;
            } 
            
            if (!Character.isLetter(tab[left])) {
                ++left;
            }
            
            if (!Character.isLetter(tab[right])) {
                --right;
            }
        }
        return new String(tab);
    }
}