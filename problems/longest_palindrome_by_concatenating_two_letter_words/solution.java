class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int result = 0;
        int sameLetters = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int occurrence = entry.getValue();
            
            if (word.charAt(0) == word.charAt(1)) {
                int mod = occurrence % 2;
                result += (occurrence - mod) * 2;
                sameLetters += mod;
                continue;
            }
            
            String reverse = "" + word.charAt(1) + word.charAt(0);
            int reverseOccurrence = map.getOrDefault(reverse, -1);
            if (reverseOccurrence > 0) {
                int min = Math.min(occurrence, reverseOccurrence);
                result += min * 2 * 2;
                map.put(word, occurrence - min);
                map.put(reverse, reverseOccurrence - min);
            }
        }
        
        if (sameLetters > 0) {
            result += 2;
        }
        
        return result;
    }
}