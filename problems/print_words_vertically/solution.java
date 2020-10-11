class Solution {
    public List<String> printVertically(String s) {
        List<String> result = new LinkedList<>();
        String[] words = s.split(" ");
        int maxLength = -1;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        
        for (int letterIndex = 0; letterIndex < maxLength; ++letterIndex) {
            StringBuilder b = new StringBuilder();
            
            for (String word : words) {
                if (word.length() <= letterIndex) {
                    b.append(' ');
                } else {
                    b.append(word.charAt(letterIndex));
                }
            }
            
            int newLength = b.length();
            while (newLength > 0 && b.charAt(newLength - 1) == ' ') {
                --newLength;
            }
            if (newLength != b.length()) {
                b.setLength(newLength);
            }
            result.add(b.toString());
        }
        
        return result;
    }
}