class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder b = new StringBuilder();
        String sep = "";
        
        for (String word : words) {
            b.append(sep);
            for (int i = word.length() - 1; i >= 0; --i) {
                b.append(word.charAt(i));
            }
            sep = " ";
        }
        
        return b.toString();
    }
}