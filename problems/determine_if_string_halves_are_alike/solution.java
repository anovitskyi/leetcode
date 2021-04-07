class Solution {
    public boolean halvesAreAlike(String s) {
        int vowels = 0;
        
        for (int aPointer = 0, bPointer = s.length() / 2; 
             bPointer < s.length(); 
             ++aPointer, ++bPointer) {
            if (isVowel(s.charAt(aPointer))) {
                ++vowels;
            }
            
            if (isVowel(s.charAt(bPointer))) {
                --vowels;
            }
        }
        
        return vowels == 0;
    }
    
    private boolean isVowel(char ch) {
        if (ch >= 97) {
            ch -= 32;
        }
        
        switch (ch) {
            case 'A':
            case 'O':
            case 'U':
            case 'I':
            case 'E':
                return true;
            default: 
                return false;
        }
    }
}