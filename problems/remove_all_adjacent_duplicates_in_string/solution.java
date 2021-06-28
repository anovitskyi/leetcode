class Solution {
    public String removeDuplicates(String s) {
        char[] tab = s.toCharArray();
        int write = 0;
        for (int read = 1; read < tab.length; ++read) {
            if (write >= 0 && tab[read] == tab[write]) {
                --write;
            } else {
                tab[++write] = tab[read];
            }
        }
        return new String(tab, 0, write + 1);
    }
}