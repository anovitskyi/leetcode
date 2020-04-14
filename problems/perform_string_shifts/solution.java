class Solution {
    public String stringShift(String s, int[][] shift) {
        if (shift == null || shift.length == 0 || s == null || s.length() < 2) {
            return s;
        }
        
        int step = 0;
        for (int i = 0; i < shift.length; ++i) {
            int value = shift[i][1];
            if (shift[i][0] == 0) {
                value *= -1;
            }
            
            step += value;
        }
        if (step == 0 || Math.abs(step) == s.length()) {
            return s;
        }
        
        
        
        char[] tab = s.toCharArray();
        char[] res = new char[tab.length];
        for (int i = 0; i < tab.length; ++i) {
            int index = i + step;
            if (index < 0 || index >= tab.length) {
                index %= tab.length;
                if (index < 0) {
                    index += tab.length;
                }
            }
            
            res[index] = tab[i];
        }
        
        return new String(res);
    }
}