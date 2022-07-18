class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int foundLetters = 0;
        for (int i = 0; i < p.length(); ++i) {
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) {
                int counter = map.get(ch);
                if (counter == 1) {
                    ++foundLetters;
                }
                map.put(ch, counter - 1);
            }
        }
        
        for (int i = p.length(); i < s.length(); ++i) {
            if (foundLetters == map.size()) {
                result.add(i - p.length());
            }
            
            char leftChar = s.charAt(i - p.length());
            if (map.containsKey(leftChar)) {
                int leftCounter = map.get(leftChar);
                if (leftCounter == 0) {
                    --foundLetters;
                }
                map.put(leftChar, leftCounter + 1);
            }
            
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                int rightCounter = map.get(rightChar);
                if (rightCounter == 1) {
                    ++foundLetters;
                }
                map.put(rightChar, rightCounter - 1);
            }
        }
        
        if (foundLetters == map.size()) {
            result.add(s.length() - p.length());
        }
        
        return result;
    }
}