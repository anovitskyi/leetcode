class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char rch = s.charAt(right);
            map.put(rch, map.getOrDefault(rch, 0) + 1);
            ++right;

            int max = 0;
            for (int value : map.values()) {
                if (value > max) {
                    max = value;
                }
            }

            int distance = right - left;
            if (distance - max > k) {
                char lch = s.charAt(left);
                map.put(lch, map.get(lch) - 1);
                ++left;
                --distance;
            }

            if (distance > result) {
                result = distance;
            }
        }

        return result;
    }
}