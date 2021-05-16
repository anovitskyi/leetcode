class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                --k;
                if (k == 0) {
                    break;
                }
            }
            b.append(ch);
        }
        
        return b.toString();
    }
}