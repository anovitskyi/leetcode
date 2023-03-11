class Solution {
    private static final Map<Character, List<Character>> numbers = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        backtrack(digits, 0, result, builder);
        
        return result;
    }

    private void backtrack(String digits, int index, List<String> result, StringBuilder builder) {
        if (index >= digits.length()) {
            result.add(builder.toString());
            return;
        }

        List<Character> possibleLetters = numbers.getOrDefault(digits.charAt(index), Collections.emptyList());
        for (char letter : possibleLetters) {
            builder.append(letter);
            backtrack(digits, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}