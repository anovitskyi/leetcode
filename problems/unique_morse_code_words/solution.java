class Solution {
    private static final String[] letters = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>(words.length);
        
        for (String word : words) {
            StringBuilder b = new StringBuilder();
            
            for (char ch : word.toCharArray()) {
                b.append(letters[ch - 'a']);
            }
            
            set.add(b.toString());
        }
        
        return set.size();
    }
}