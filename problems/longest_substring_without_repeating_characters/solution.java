class Solution {
    public int lengthOfLongestSubstring(String s) {
        int last = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) {
                last = Math.max(last, map.get(ch) + 1);
            }
            
            map.put(ch, i);
            result = Math.max(result, i - last + 1);
        }
        
        return result;
    }
}