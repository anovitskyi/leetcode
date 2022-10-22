class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int foundLetters = 0;
        int left = 0;
        int right = 0;
        int leftResult = -1;
        int rightResult = s.length();
        
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            if (map.containsKey(rightCh)) {
                int prev = map.get(rightCh);
                map.put(rightCh, prev - 1);
                
                if (prev == 1) {
                    ++foundLetters;
                }
            }
            ++right;
            
            if (foundLetters == map.size()) {
                while (!map.containsKey(s.charAt(left)) || map.get(s.charAt(left)) < 0) {
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    }
                    ++left;
                }
                
                if (right - left < rightResult - leftResult) {
                    leftResult = left;
                    rightResult = right; 
                }
                
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                --foundLetters;
                ++left;
            }
        }
        
        if (leftResult == -1) {
            return "";
        }
        
        return s.substring(leftResult, rightResult);
    }
}

/*
                |
    ADOBECODEBANC
             |
*/