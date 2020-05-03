class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        
        int[] chars = new int[26];
        for (char ch : magazine.toCharArray()) {
            ++chars[ch - 97];
        }
        
        for (char ch : ransomNote.toCharArray()) {
            if (chars[ch - 97] <= 0) {
                return false;
            }
            
            --chars[ch - 97];
        }
        
        return true;
    }
}