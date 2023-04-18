class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < word1.length() || pointer2 < word2.length()) {

            if (pointer1 < word1.length()) {
                builder.append(word1.charAt(pointer1));
                ++pointer1;
            }
            
            if (pointer2 < word2.length()) {
                builder.append(word2.charAt(pointer2));
                ++pointer2;
            }
            
        }

        return builder.toString();
    }   
}