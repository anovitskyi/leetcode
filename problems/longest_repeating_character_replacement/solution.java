class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;

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

            int remainingChars = right - left - max;
            if (remainingChars > k) {
                char lch = s.charAt(left);
                map.put(lch, map.get(lch) - 1);
                ++left;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }
}