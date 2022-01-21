class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    
    public String reverseVowels(String s) {
        char[] tab = s.toCharArray();
        int left = 0;
        int right = tab.length - 1;
        
        while (left < right) {
            if (!vowels.contains(tab[left])) {
                ++left;
            } else if (!vowels.contains(tab[right])) {
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
    
}