class Solution {
    
    private final Map<Character, String> map = new HashMap<>(8);
    
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        
        if (digits.length() > 0) {
            backtrack("", digits, result);   
        }
        
        return result;
    }
    
    private void backtrack(String word, String digits, List<String> result) {
        if (word.length() >= digits.length()) {
            result.add(word);
            return;
        }
        
        String arr = map.get(digits.charAt(word.length()));
        for (char ch : arr.toCharArray()) {
            backtrack(word + ch, digits, result);
        }
    }
}