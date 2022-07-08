class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedLetters = new HashSet<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (mappedLetters.contains(tChar)) {
                    return false;
                }
                
                mappedLetters.add(tChar);
                map.put(sChar, tChar);
            }
        }
        
        return true;
    }
}