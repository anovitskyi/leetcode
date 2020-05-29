class Solution {
    public boolean judgeCircle(String moves) {
        int h, v;
        h = v = 0;
        
        char[] tab = moves.toCharArray();
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == 'U') {
                ++v;
            } else if (tab[i] == 'D') {
                --v;
            } else if (tab[i] == 'R') {
                ++h;
            } else {
                --h;
            }
            
        }
        
        return h == 0 && v == 0;
    }
}