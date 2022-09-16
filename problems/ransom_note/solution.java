class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        int[] tab = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            int ch = magazine.charAt(i) - 'a';
            --tab[ch];
        }
        
        for (int i = 0; i < ransomNote.length(); ++i) {
            int ch = ransomNote.charAt(i) - 'a';
            
            if (tab[ch] == 0) {
                return false;
            }
            
            ++tab[ch];
        }
        
        return true;
    }
}