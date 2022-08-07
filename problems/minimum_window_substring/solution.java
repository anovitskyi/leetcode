class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
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
        int leftResult = 0;
        int rightResult = s.length() + 1;
        
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            if (map.containsKey(rightCh)) {
                map.put(rightCh, map.get(rightCh) - 1);
                if (map.get(rightCh) == 0) {
                    ++foundLetters;
                }
            }
            ++right;
            
            if (foundLetters == map.size()) {
                while (map.getOrDefault(s.charAt(left), -1) < 0) {
                    char leftCh = s.charAt(left);
                    if (map.containsKey(leftCh)) {
                        map.put(leftCh, map.get(leftCh) + 1);
                    }
                    ++left;
                }
                
                if ((right - left) < (rightResult - leftResult)) {
                    leftResult = left;
                    rightResult = right;   
                }
                
                while (foundLetters == map.size()) {
                    char leftCh = s.charAt(left);
                    if (map.containsKey(leftCh)) {
                        map.put(leftCh, map.get(leftCh) + 1);
                        if (map.get(leftCh) == 1) {
                            --foundLetters;
                        }
                    }
                    ++left;
                }
            }
        }
        
        if (rightResult == s.length() + 1) {
            return "";
        }
        return s.substring(leftResult, rightResult);
    }
}