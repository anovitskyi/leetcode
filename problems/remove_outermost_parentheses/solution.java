class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder b = new StringBuilder();
        
        char[] tab = S.toCharArray();
        int counter = 0;
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == '(') {
                ++counter;
                
                if (counter == 1) {
                    continue;
                }
            } else {
                --counter;
                
                if (counter == 0) {
                    continue;
                }
            }
            b.append(tab[i]);
        }
        
        
        return b.toString();
    }
}