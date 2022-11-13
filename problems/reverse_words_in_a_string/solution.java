class Solution {
    public String reverseWords(String s) {
        char[] tab = s.toCharArray();
        int read = 0;
        int write = 0;

        while (read < tab.length) {
            if (tab[read] != ' ') {
                tab[write] = tab[read];
                ++write;

                if (read + 1 < tab.length && tab[read + 1] == ' ') {
                    tab[write] = ' ';
                    ++write;
                }
            }

            ++read;
        }

        if (tab[write - 1] == ' ') {
            --write;
        }

        int left = 0;
        int right = 0;
        for (int i = 1; i < write; ++i) {
            if (tab[i] == ' ') {
                while (left < right) {
                    char tmp = tab[left];
                    tab[left] = tab[right];
                    tab[right] = tmp;
                    ++left;
                    --right;
                }

                left = i + 1;
                right = i + 1;
                ++i;
            } else {
                ++right;
            }
        }
        while (left < right) {
            char tmp = tab[left];
            tab[left] = tab[right];
            tab[right] = tmp;
            ++left;
            --right;
        }

        left = 0;
        right = write - 1;
        while (left < right) {
            char tmp = tab[left];
            tab[left] = tab[right];
            tab[right] = tmp;
            ++left;
            --right;
        }

        return new String(tab, 0, write);
    }
}

/*.           |
    "a good   example"
                     |
    "a doog   elpmaxe"
    "example good a"
 */