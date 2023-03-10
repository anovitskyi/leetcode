class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, result, curr);

        return result;
    }

    private void backtrack(String word, int start, List<List<String>> result, List<String> curr) {
        if (start >= word.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < word.length(); ++i) {
            String testWord = word.substring(start, i + 1);
            if (!isPalindrome(testWord)) {
                continue;
            }

            curr.add(testWord);
            backtrack(word, i + 1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            ++start;
            --end;
        }

        return true;
    }
}