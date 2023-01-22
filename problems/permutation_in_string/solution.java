class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int foundLetters = 0;
        for (int i = 0; i < s1.length(); ++i) {
            char ch = s2.charAt(i);

            if (!map.containsKey(ch)) {
                continue;
            }

            int count = map.get(ch);
            if (count == 1) {
                ++foundLetters;
            }
            map.put(ch, count - 1);
        }

        for (int i = s1.length(); i < s2.length(); ++i) {
            if (foundLetters == map.size()) {
                return true;
            }

            char rch = s2.charAt(i);
            if (map.containsKey(rch)) {
                int count = map.get(rch);
                if (count == 1) {
                    ++foundLetters;
                }
                map.put(rch, count - 1);
            }

            char lch = s2.charAt(i - s1.length());
            if (map.containsKey(lch)) {
                int count = map.get(lch);
                if (count == 0) {
                    --foundLetters;
                }
                map.put(lch, count + 1);
            }
        }
        return foundLetters == map.size();
    }
}