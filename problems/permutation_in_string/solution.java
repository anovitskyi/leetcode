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
            char rightCh = s2.charAt(right);
            if (map.containsKey(rightCh)) {
                int rightQuantity = map.get(rightCh);
                --rightQuantity;
                map.put(rightCh, rightQuantity);
                
                if (rightQuantity == 0) {
                    ++foundLetters;
                }
            }
            
            ++right;
        }
        
        while (foundLetters != map.size() && right < s2.length()) {
            char rightCh = s2.charAt(right);
            if (map.containsKey(rightCh)) {
                int rightQuantity = map.get(rightCh);
                --rightQuantity;
                map.put(rightCh, rightQuantity);
                
                if (rightQuantity == 0) {
                    ++foundLetters;
                }
            }
            
            char leftCh = s2.charAt(left);
            if (map.containsKey(leftCh)) {
                int leftQuantity = map.get(leftCh);
                ++leftQuantity;
                map.put(leftCh, leftQuantity);
                
                if (leftQuantity == 1) {
                    --foundLetters;
                }
            }
            
            ++right;
            ++left;
        }
        
        return foundLetters == map.size();  
    }
}