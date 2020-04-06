class Solution {
    public String freqAlphabets(String s) {
        StringBuilder b = new StringBuilder();
        
        char[] tab = s.toCharArray();
        final int size = tab.length;
        
        for (int i = 0; i < size; ++i) {
            if (i < size - 2 && tab[i + 2] == '#') {
                int num = (tab[i] - 48) * 10;
                num += (tab[i + 1] - 48);
                num += 96;
                b.append((char) (num));
                i+= 2;   
            } else {
                b.append((char) (tab[i] + 48));
            }
        }
        
        return b.toString();
    }
}