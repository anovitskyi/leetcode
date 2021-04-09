class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; ++i) {
            int minLength = Math.min(words[i].length(), words[i + 1].length());
            
            int letterIndex = 0;
            while (letterIndex < minLength) {
                int aPos = order.indexOf(words[i].charAt(letterIndex));
                int bPos = order.indexOf(words[i + 1].charAt(letterIndex));
                
                
                if (aPos < bPos) {
                    break;
                } else if (aPos > bPos) {
                    return false;
                }
                
                ++letterIndex;
            }
            
            if (letterIndex >= minLength && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }
    
        return true;
    }
}