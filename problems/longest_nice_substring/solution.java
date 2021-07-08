class Solution {
    public String longestNiceSubstring(String s) {
        CharMap charMap = new CharMap(s);
        return findNiceSubstring(s, 0, s.length(), charMap);
    }
    
    private String findNiceSubstring(String word, int left, int right, CharMap charMap) {
        if (right - left < 2) {
            return "";
        }
        
        int index = left;
        for (int i = left; i < right; ++i) {
            if (!charMap.containsCharBetween(word.charAt(i), left, right)) {
                String leftSub = findNiceSubstring(word, left, i, charMap);
                String rightSub = findNiceSubstring(word, i + 1, right, charMap);
                
                return leftSub.length() >= rightSub.length() ? leftSub : rightSub;
            }   
        }
        
        return word.substring(left, right);
    }
    
    private class CharMap {
        private final Map<Character, List<Integer>> map = new HashMap<>();
        
        private CharMap(String word) {
            for (int i = 0; i < word.length(); ++i) {
                map.computeIfAbsent(word.charAt(i), ch -> new LinkedList<>()).add(i);
            }
        }
        
        private boolean containsCharBetween(char ch, int left, int right) {
            char chToFind = (char) (ch >= 'a' && ch <= 'z' ? ch - 32 : ch + 32);
            List<Integer> list = map.get(chToFind);
            if (list == null) {
                return false;
            }
            
            for (int index : list) {
                if (index >= left && index < right) {
                    return true;
                }
            }
            return false;
        }
    }
}