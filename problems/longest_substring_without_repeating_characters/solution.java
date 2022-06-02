class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            
            if (map.containsKey(rightCh)) {
                left = Math.max(left, map.get(rightCh) + 1);
            }
            
            map.put(rightCh, right);
            ++right;
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}