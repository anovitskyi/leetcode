class Solution {
    
    private static final Map<Character, String> map = new HashMap<>();
    
    static {
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
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(result, "", digits, 0);
        return result;
    }
    
    private void backtrack(List<String> result, String curr, String digits, int digitIndex) {
        if (digitIndex >= digits.length()) {
            result.add(curr);
            return;
        }
        
        String letters = map.get(digits.charAt(digitIndex));
        for (int i = 0; i < letters.length(); ++i) {
            backtrack(result, curr + letters.charAt(i), digits, digitIndex + 1);
        }
    }
}