class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int lastVisited = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                lastVisited = Math.max(lastVisited, map.get(ch) + 1);
            }
            
            map.put(ch, i);
            result = Math.max(result, i - lastVisited + 1);
        }
        
        return result;
    }
}