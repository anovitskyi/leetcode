class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), s, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder b, String s, int index) {
        for (int i = index; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            if (Character.isLetter(ch)) {
                StringBuilder copy = new StringBuilder(b);
                copy.append(Character.toUpperCase(ch));
                backtrack(result, copy, s, i + 1);
                
                b.append(Character.toLowerCase(ch));
            } else {
                b.append(ch);
            }
        }
        
        result.add(b.toString());
    }
}