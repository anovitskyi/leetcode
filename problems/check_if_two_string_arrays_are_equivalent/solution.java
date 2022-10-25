class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int left = 0;
        int leftP = 0;
        int right = 0;
        int rightP = 0;
        
        while (left < word1.length && right < word2.length) {
            if (leftP >= word1[left].length()) {
                ++left;
                leftP = 0;
                continue;
            }
            
            if (rightP >= word2[right].length()) {
                ++right;
                rightP = 0;
                continue;
            }
            
            if (word1[left].charAt(leftP) != word2[right].charAt(rightP)) {
                return false;
            }
            
            ++leftP;
            ++rightP;
        }
        
        if (left < word1.length && leftP >= word1[left].length()) {
            ++left;
        }
        
        if (right < word2.length && rightP >= word2[right].length()) {
            ++right;
        }
        
        return left == word1.length && right == word2.length;
    }
}