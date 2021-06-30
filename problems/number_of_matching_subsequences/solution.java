class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Pattern pattern = new Pattern(s);
        int result = 0;
        
        for (String word : words) {
            if (isSubsequent(pattern, word)) {
                ++result;
            }
        }
        
        return result;
    }
    
    private boolean isSubsequent(Pattern pattern, String word) {
        int index = -1;
        
        for (char ch : word.toCharArray()) {
            if ((index = pattern.lastCharacter(ch, index)) == -1) {
                return false;
            }
        }
        
        return true;
    }
    
    private class Pattern {
        
        private final Map<Character, List<Integer>> map = new HashMap<>();
        
        Pattern(String pattern) {
            for (int i = 0; i < pattern.length(); ++i) {
                map.computeIfAbsent(pattern.charAt(i), ch -> new ArrayList<>(pattern.length() * 2))
                    .add(i);
            }
        }
        
        int lastCharacter(char ch, int after) {
            List<Integer> list = map.get(ch);
            if (list == null) {
                return -1;
            }
            
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = ((right - left) / 2) + left;
                int elem = list.get(mid);
                if (elem <= after) {
                    left = mid + 1;
                } else if (mid > 0 && list.get(mid - 1) > after) {
                    right = mid - 1;
                } else {
                    return elem;
                }
                
            }
            
            return -1;
        }
        
    }
}