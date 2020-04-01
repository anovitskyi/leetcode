class Solution {
    
    private static final String[] morse;
    
    static {
        morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    }
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>(words.length);
        
        for (String word : words) {
            String trans = transform(word);
            set.add(trans);
        }
        
        return set.size();
    }
    
    private String transform(String word) {
        StringBuilder b = new StringBuilder();
        char[] tab = word.toLowerCase().toCharArray();
        
        for (char ch : tab) {
            int index = ch - 97;
            b.append(morse[index]);
        }
        
        return b.toString();
    }
}