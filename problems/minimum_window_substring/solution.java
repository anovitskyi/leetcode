class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int resultLeft = -1;
        int resultRight = -1;
        int left = 0;
        int right = 0;
        int size = map.size();

        while (right < s.length()) {
            char rch = s.charAt(right);
            if (map.containsKey(rch)) {
                int count = map.get(rch);
                map.put(rch, count - 1);
                
                if (count == 1) {
                    --size;
                }
            }
            ++right;

            if (size == 0) {
                while (left < right) {
                    char lch = s.charAt(left);

                    if (map.getOrDefault(lch, Integer.MIN_VALUE) >= 0) {
                        break;
                    } else if (map.containsKey(lch)) {
                        map.put(lch, map.get(lch) + 1);
                    }

                    ++left;
                }

                if (resultLeft == -1 || right - left < resultRight - resultLeft) {
                    resultLeft = left;
                    resultRight = right;    
                }

                char lch = s.charAt(left);
                map.put(lch, map.get(lch) + 1);
                ++size;
                ++left;
            }
        }

        if (resultLeft == -1) {
            return "";
        }
        return s.substring(resultLeft, resultRight);
    }
}