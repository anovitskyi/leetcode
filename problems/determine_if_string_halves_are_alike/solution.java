class Solution {

    private static final Set<Character> vowels = Set.of(
        'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    );

    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        int a = 0;
        int b = 0;

        for (int i = 0; i < half; ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++a;
            }

            if (vowels.contains(s.charAt(i + half))) {
                ++b;
            }
        }

        return a == b;
    }
}