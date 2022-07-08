class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if (s.length() > t.length()) {
//             return false;
//         }
        
//         int sIndex = 0;
//         for (int tIndex = 0; sIndex < s.length() && tIndex < t.length(); ++tIndex) {
//             if (s.charAt(sIndex) == t.charAt(tIndex)) {
//                 ++sIndex;
//             }
//         }
        
//         return sIndex == s.length();
//     }
    
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            map.computeIfAbsent(t.charAt(i), x -> new ArrayList<>()).add(i);
        }
        
        int lastIndex = -1;
        for (int i = 0; i < s.length(); ++i) {
            List<Integer> indexes = map.get(s.charAt(i));
            if (indexes == null) {
                return false;
            }
            
            int lastLetterOccuranceIndex = findLetterOccurance(indexes, lastIndex);
            if (lastLetterOccuranceIndex == -1) {
                return false;
            }
            
            lastIndex = lastLetterOccuranceIndex;
        }
        
        return true;
    }
    
    private int findLetterOccurance(List<Integer> indexes, int minimumIndex) {
        int left = 0;
        int right = indexes.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (indexes.get(middle) > minimumIndex) {
                result = indexes.get(middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return result;
    }
}