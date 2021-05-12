class Solution {
    public int maxVowels(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        
        Set<Character> set = getVowelsSet();
        int curr = 0;
        for (int i = 0; i < k; ++i) {
            if (set.contains(s.charAt(i))) {
                ++curr;
            }
        }
        
        int max = curr;
        for (int i = k; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                ++curr;
            }
            
            if (set.contains(s.charAt(i - k))) {
                --curr;
            }
            
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
    
    private Set<Character> getVowelsSet() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set;
    }
}