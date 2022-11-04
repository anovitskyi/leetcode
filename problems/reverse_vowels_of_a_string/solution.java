class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] tab = s.toCharArray();

        while (left < right) {
            if (!VOWELS.contains(tab[left])) {
                ++left;
                continue;
            }

            if (!VOWELS.contains(tab[right])) {
                --right;
                continue;
            }

            char tmp = tab[left];
            tab[left] = tab[right];
            tab[right] = tmp;
            ++left;
            --right;
        }

        return new String(tab);
    }

}