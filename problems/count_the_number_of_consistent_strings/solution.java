class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); ++i) {
            allowedSet.add(allowed.charAt(i));
        }
        
        int result = 0;
        
        for (String word : words) {
            boolean found = true;
            for (int i = 0; i < word.length(); ++i) {
                if (!allowedSet.contains(word.charAt(i))) {
                    found = false;
                    break;
                }
            }
            
            if (found) {
                ++result;
            }
        }
        return result;
    }
}