class Solution {
    public String mergeAlternately(String word1, String word2) {
        int maxLength = Math.max(word1.length(), word2.length());
        StringBuilder b = new StringBuilder();
        
        for (int i = 0; i < maxLength; ++i) {
            if (i < word1.length()) {
                b.append(word1.charAt(i));
            }
            
            if (i < word2.length()) {
                b.append(word2.charAt(i));
            }
        }
        
        return b.toString();
    }
}