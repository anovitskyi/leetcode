class Solution {
    
    static List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> result = new ArrayList<>();
    for (String query: queries) {
      result.add(matchesPattern(pattern, query));
    }
    
    return result;
  }
  
  private static boolean matchesPattern(String pattern, String query) {
    
    if (query.length() < pattern.length()) return false;
    
    int i = 0, j = 0;
    while (i < pattern.length()) {

      while (j < query.length() && pattern.charAt(i) != query.charAt(j)) {
        if (query.charAt(j) >= 'A' && query.charAt(j) <= 'Z') return false;
        
        j++;
      }
      
      if (j < query.length()) {
        i++;
        j++;
      } else return false;
      
    }
    
    
    while (j < query.length()) {
      if (query.charAt(j) >= 'A' && query.charAt(j) <= 'Z') return false;
      j++;
    }
    
    
    return true;
  }
//     public List<Boolean> camelMatch(String[] queries, String pattern) {
//         List<Boolean> result = new ArrayList<>(queries.length);
//         for (String query : queries) {
//             result.add(matchPattern(query, pattern));
//         }
//         return result;
//     }
    
//     private boolean matchPattern(String query, String pattern) {
//         int patternIndex = 0;
//         for (int i = 0; i < query.length(); ++i) {
//             char ch = query.charAt(i);
            
//             if (ch == pattern.charAt(patternIndex)) {
//                 ++patternIndex;
//                 if (patternIndex == pattern.length()) {
//                     for (int j = i + 1; j < query.length(); ++j) {
//                         if (Character.isUpperCase(query.charAt(j))) {
//                             return false;
//                         }
//                     }
//                     return true;
//                 }
//             } else if (Character.isUpperCase(ch)) {
//                 return false;
//             }
//         }
        
//         return patternIndex == pattern.length();
//     }
}