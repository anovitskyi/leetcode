class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        
        char[] tab = palindrome.toCharArray();
        int firstNonA = -1;
        for (int i = 0; i < tab.length / 2; ++i) {
            if (tab[i] != 'a') {
                firstNonA = i;
                break;
            }
        }
        
        if (firstNonA != -1) {
            tab[firstNonA] = 'a';
        } else {
            tab[tab.length - 1] = 'b';
        }
        
        return new String(tab);
    }
}