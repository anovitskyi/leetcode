class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int result = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                
                if (word.equals(endWord)) {
                    return result;
                }

                for (int i = 0; i < wordList.size(); ++i) {
                    String nextWord = wordList.get(i);

                    if (nextWord.isEmpty() || hasBigDifference(word, nextWord)) {
                        continue;
                    }

                    wordList.set(i, "");
                    queue.offer(nextWord);
                }
            }
            ++result;
        }

        return 0;
    }

    private boolean hasBigDifference(String a, String b) {
        if (a.length() != b.length()) {
            return true;
        }

        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++diff;
            }
        }
        return diff != 1;
    }
}