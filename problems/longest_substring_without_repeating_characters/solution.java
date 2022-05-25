class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char ch = s.charAt(right);
            
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            ++right;
            result = Math.max(result, right - left);
        }
        
        return Math.max(result, right - left);
    }
}

/*

    result = 3

    |
    abcabcbb
       |
    
    01234567

*/