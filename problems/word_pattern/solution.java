class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        Set<String> visitedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char key = pattern.charAt(i);
            
            if (!map.containsKey(key)) {
                if (visitedWords.contains(words[i])) {
                    return false;
                }
                
                map.put(key, words[i]);
                visitedWords.add(words[i]);
            } else if (!map.get(key).equals(words[i])) {
                    return false;
            }
            
        }
        return true;
    }
}