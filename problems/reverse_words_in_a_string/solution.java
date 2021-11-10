class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        
        s = s.trim();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    ++i;
                }
                builder.insert(0, " ");
            } else {
                StringBuilder b = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ' ') {
                    b.append(s.charAt(i));
                    ++i;
                }
                builder.insert(0, b.toString());
            }
        }
        
        return builder.toString();
    }
}