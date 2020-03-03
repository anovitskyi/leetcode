class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        
        int counter = 0;
        char[] tab = s.toCharArray();
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == 'L') {
                ++counter;
            } else {
                --counter;
            }
            
            if (counter == 0) {
                ++res;
            }
        }
        
        return res;
    }
}