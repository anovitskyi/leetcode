class Solution {
    public String toLowerCase(String str) {
        StringBuilder b = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                b.append((char) (ch + 32));
            } else {
                b.append(ch);
            }
        }
        
        return b.toString();
    }
}