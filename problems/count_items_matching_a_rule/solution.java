class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleIndex = getRuleIndex(ruleKey);
        int result = 0;
        
        for (List<String> line : items) {
            if (line.get(ruleIndex).equals(ruleValue)) {
                ++result;
            }
        }
        
        return result;
    }
    
    private int getRuleIndex(String ruleKey) {
        switch (ruleKey) {
            case "type": return 0;
            case "color": return 1;
            case "name": return 2;
            default: return -1;
        }
    }
}