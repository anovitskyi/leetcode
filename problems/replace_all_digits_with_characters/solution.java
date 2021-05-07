class Solution {
    public String replaceDigits(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder b = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 0) {
                b.append(s.charAt(i));
            } else {
                int steps = s.charAt(i) - '0';
                int newIndex = alpha.indexOf(s.charAt(i - 1)) + steps;
                char shifted = alpha.charAt(newIndex);
                b.append(shifted);
            }
        }
        
        return b.toString();
    }
}