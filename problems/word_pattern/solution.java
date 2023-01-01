class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>(pattern.length());
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < words.length; ++i) {
            char key = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(key)) {
                if (!map.get(key).equals(word)) {
                    return false;
                }
            } else {
                if (visited.contains(word)) {
                    return false;
                }
                visited.add(word);
                map.put(key, word);
            }
        }

        return true;
    }
}