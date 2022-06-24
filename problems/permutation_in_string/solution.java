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
        
        int foundLetters = 0;
        for (int i = 0; i < s1.length(); ++i) {
            char ch = s2.charAt(i);
            if (!map.containsKey(ch)) {
                continue;
            }
            
            int counter = map.get(ch);
            map.put(ch, counter - 1);
            
            if (counter == 1) {
                ++foundLetters;   
            }
        }
        
        for (int i = s1.length(); i < s2.length(); ++i) {
            if (foundLetters == map.size()) {
                return true;
            }
            
            char rightCh = s2.charAt(i);
            if (map.containsKey(rightCh)) {
                int rightCounter = map.get(rightCh);
                map.put(rightCh, rightCounter - 1);
                
                if (rightCounter == 1) {
                    ++foundLetters;
                }
            }
            
            char leftCh = s2.charAt(i - s1.length());
            if (map.containsKey(leftCh)) {
                int leftCounter = map.get(leftCh);
                map.put(leftCh, leftCounter + 1);
                
                if (leftCounter == 0) {
                    --foundLetters;   
                }
            }
        }
        
        return foundLetters == map.size();
    }
}

/*

{
    a: 0
    d: 0
    c: 0
}

foundLetters = 3

  |
"dcda"
     |
*/












