class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder b = new StringBuilder();
        int wordCounter = 1;
        
        for (int i = 0; i < sentence.length(); ++i) {
            boolean isVowel = isVowelLetter(sentence.charAt(i));
            char firstLetter = sentence.charAt(i);
            if (!isVowel) {
                ++i;
            }
            
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                b.append(sentence.charAt(i));
                ++i;
            }
            
            if (!isVowel) {
                b.append(firstLetter);
            }
            b.append("ma");
            
            for (int j = 0; j < wordCounter; ++j) {
                b.append("a");
            }
            ++wordCounter;
            
            if (i < sentence.length()) {
                b.append(" ");
            }
        }
        return b.toString();
    }
    
    private boolean isVowelLetter(char ch) {
        return ch == 'a' || ch == 'A'
            || ch == 'e' || ch == 'E'
            || ch == 'i' || ch == 'I'
            || ch == 'o' || ch == 'O'
            || ch == 'u' || ch == 'U';
    }
}