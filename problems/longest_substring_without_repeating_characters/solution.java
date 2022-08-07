class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < s.length()) {
            char ch = s.charAt(right);
            
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            
            map.put(ch, right);
            ++right;
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}