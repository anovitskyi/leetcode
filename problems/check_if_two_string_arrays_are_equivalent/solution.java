class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int ich = 0;
        int j = 0;
        int jch = 0;
        
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(ich) != word2[j].charAt(jch)) {
                return false;
            }
            
            if (ich + 1 >= word1[i].length()) {
                ++i;
                ich = 0;
            } else {
                ++ich;
            }
            
            if (jch + 1 >= word2[j].length()) {
                ++j;
                jch = 0;
            } else {
                ++jch;
            }
        }
        
        return i == word1.length && j == word2.length;
    }
}