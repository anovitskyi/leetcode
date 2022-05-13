class Solution {
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            if (left > right) {
                ++right;
            } else if (map.getOrDefault(rightChar, 0) == 0) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
                ++right;
            } else {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                result = Math.max(result, right - left);
                ++left;
            }
        }
        
        return Math.max(result, right - left);
    }
    
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar) + 1);
            }
            
            map.put(rightChar, right);
            ++right;
            result = Math.max(right - left, result);
        }
        
        return Math.max(result, right - left);
    }
}

/*

        |
"abcabcbb"
         |
 
 result = 3
 [
    a: 0
    b: 1
    c: 0
 ]

*/