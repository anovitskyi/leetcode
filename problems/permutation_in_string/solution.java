class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char s1Char = s1.charAt(i);
            
            map.put(s1Char, map.getOrDefault(s1Char, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int matchedLetters = 0;
        
        while (right < s1.length()) {
            char rightChar = s2.charAt(right);
            
            if (map.containsKey(rightChar)) {
                int counter = map.get(rightChar);
                
                if (counter == 1) {
                    ++matchedLetters;
                }
                
                map.put(rightChar, counter - 1);
            }
            
            ++right;
        }
        
        while (right < s2.length()) {
            if (matchedLetters == map.size()) {
                return true;
            }
            
            char rightChar = s2.charAt(right);
            if (map.containsKey(rightChar)) {
                int counter = map.get(rightChar);
                
                if (counter == 1) {
                    ++matchedLetters;
                }
                
                map.put(rightChar, counter - 1);
            }
            
            char leftChar = s2.charAt(left);
            if (map.containsKey(leftChar)) {
                int counter = map.get(leftChar);
                
                if (counter == 0) {
                    --matchedLetters;
                }
                
                map.put(leftChar, counter + 1);
            }
            
            ++right;
            ++left;
        }
        
        return matchedLetters == map.size();
    }
}


/*
    hello
    matched = 0
    
    
    |
    ooolleoooleh
    |



*/