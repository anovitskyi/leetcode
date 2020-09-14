class Solution {
    public boolean checkRecord(String s) {
        char[] tab = s.toCharArray();
        
        int as = 0;
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == 'A') {
                if (as == 1) {
                    return false;
                }
                ++as;
            }
            
            if (tab[i] == 'L' && i + 2 < tab.length && tab[i + 1] == 'L' && tab[i + 2] == 'L') {
                return false;
            }
        }
        
        return true;
    }
}