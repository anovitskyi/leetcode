class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> cache = new HashSet<>();
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        for (int i = 0; i < pattern.length(); ++i) {
            char letter = pattern.charAt(i);
            
            if (!map.containsKey(letter)) {
                if (cache.contains(words[i])) {
                    return false;
                }
                
                cache.add(words[i]);
                map.put(letter, words[i]);
            } else if (!words[i].equals(map.get(letter))) {
                return false;
            }
        }
        
        return true;
    }
}