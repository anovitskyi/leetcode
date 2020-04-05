class Solution {
    public String sortString(String s) {
        StringBuilder b = new StringBuilder();
        
        char[] tab = s.toCharArray();
        Arrays.sort(tab, 0, tab.length);
        
        int counter = 0;
        while (counter < tab.length) {
            char last = 0;
            for (int i = 0; i < tab.length; ++i) {
                if (tab[i] != 0 && tab[i] > last) {
                    ++counter;
                    last = tab[i];
                    b.append(tab[i]);
                    tab[i] = 0;
                }
            }
            
            last = 127;
            for (int i = tab.length - 1; i >= 0; --i) {
                if (tab[i] != 0 && tab[i] < last) {
                    ++counter;
                    last = tab[i];
                    b.append(tab[i]);
                    tab[i] = 0;
                }
            }
        }
        
        return b.toString();
    }
}