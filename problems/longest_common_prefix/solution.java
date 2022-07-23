class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder b = new StringBuilder();
        
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        
        for (int i = 0; i < minLength; ++i) {
            int counter = 0;
            for (String str : strs) {
                if (str.charAt(i) == strs[0].charAt(i)) {
                    ++counter;
                }
            }
            
            if (counter != strs.length) {
                break;
            }
            b.append(strs[0].charAt(i));
        }
        
        return b.toString();
    }
}