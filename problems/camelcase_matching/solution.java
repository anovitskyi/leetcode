class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (String query : queries) {
            result.add(matchPattern(query, pattern));
        }
        return result;
    }
    
    private boolean matchPattern(String query, String pattern) {
        int patternIndex = 0;
        for (int i = 0; i < query.length(); ++i) {
            char ch = query.charAt(i);
            
            if (ch == pattern.charAt(patternIndex)) {
                ++patternIndex;
                if (patternIndex == pattern.length()) {
                    for (int j = i + 1; j < query.length(); ++j) {
                        if (Character.isUpperCase(query.charAt(j))) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        
        return patternIndex == pattern.length();
    }
}