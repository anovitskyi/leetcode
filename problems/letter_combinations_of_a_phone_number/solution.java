class Solution {

    private static final Map<Character, List<Character>> mapper = Map.of(
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
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder builder, List<String> result) {
        if (index >= digits.length()) {
            result.add(builder.toString());
            return;
        }

        List<Character> letters = mapper.get(digits.charAt(index));
        for (char letter : letters) {
            builder.append(letter);
            backtrack(digits, index + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}