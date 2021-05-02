class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            int curr = find(i, s);
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }
    
    private int find(int index, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = index; i < s.length(); ++i) {
            if (!set.add(s.charAt(i))) {
                break;
            }
        }
        return set.size();
    }
}