class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int last = -1;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            int currLast = map.getOrDefault(ch, last);
            if (currLast > last) {
                last = currLast;
            }

            int diff = i - last;
            if (diff > result) {
                result = diff;
            }
            
            map.put(ch, i);
        }

        return result;
    }
}