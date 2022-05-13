class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }   
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int foundLetters = 0;
        
        while (right < s1.length()) {
            char rightChar = s2.charAt(right);
            
            if (map.containsKey(rightChar)) {
                int counter = map.get(rightChar) - 1;
                if (counter == 0) {
                    ++foundLetters;
                }
                map.put(rightChar, counter);
            }
            
            ++right;
        }
        
        while (right < s2.length()) {
            if (foundLetters == map.size()) {
                return true;
            }
            
            char rightChar = s2.charAt(right);
            if (map.containsKey(rightChar)) {
                int counter = map.get(rightChar) - 1;
                if (counter == 0) {
                    ++foundLetters;
                }
                map.put(rightChar, counter);
            }
            
            char leftChar = s2.charAt(left);
            if (map.containsKey(leftChar)) {
                int counter = map.get(leftChar);
                if (counter == 0) {
                    --foundLetters;
                }
                map.put(leftChar, counter + 1);
            }
            
            ++right;
            ++left;
        }
        
        return foundLetters == map.size();
    }
}

/*



"ab"
    |
"eidboaoo"
      |
 
 a: 0
 b: 1
 foundLetters: 1




*/