class Solution {
    
    private static final Map<Character, List<Character>> digitMap = new HashMap<>();
    
    static {
        digitMap.put('2', List.of('a', 'b', 'c'));
        digitMap.put('3', List.of('d', 'e', 'f'));
        digitMap.put('4', List.of('g', 'h', 'i'));
        digitMap.put('5', List.of('j', 'k', 'l'));
        digitMap.put('6', List.of('m', 'n', 'o'));
        digitMap.put('7', List.of('p', 'q', 'r', 's'));
        digitMap.put('8', List.of('t', 'u', 'v'));
        digitMap.put('9', List.of('w', 'x', 'y', 'z'));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.isEmpty()) {
            return result;
        }
        
        backtrack(result, "", digits, 0);
        return result;
    }
    
    private void backtrack(List<String> result, String curr, String digits, int digitIndex) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }
        
        List<Character> mappedLetters = digitMap.get(digits.charAt(digitIndex));
        for (char d : mappedLetters) {
            backtrack(result, curr + d, digits, digitIndex + 1);
        }
    }
    
}