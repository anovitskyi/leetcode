class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int lastRepeat = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (map.containsKey(ch) && map.get(ch) > lastRepeat) {
                lastRepeat = map.get(ch);
            }

            int distance = i - lastRepeat;
            if (distance > result) {
                result = distance;
            }

            map.put(ch, i);
        }

        return result;
    }
}