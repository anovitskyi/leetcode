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
            
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                map.put(ch, val - 1);
                if (val == 1) {
                    ++foundLetters;
                }
            }
        }
        
        for (int i = s1.length(); i < s2.length(); ++i) {
            if (foundLetters == map.size()) {
                return true;
            }
            
            char rightCh = s2.charAt(i);
            if (map.containsKey(rightCh)) {
                int val = map.get(rightCh);
                map.put(rightCh, val - 1);
                if (val == 1) {
                    ++foundLetters;
                }
            }
            
            char leftCh = s2.charAt(i - s1.length());
            if (map.containsKey(leftCh)) {
                int val = map.get(leftCh);
                map.put(leftCh, val + 1);
                if (val == 0) {
                    --foundLetters;
                }
            }
        }
        
        return foundLetters == map.size();
    }
}