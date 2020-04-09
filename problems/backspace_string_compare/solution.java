class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();
        
        int aSize = replaceTab(a);
        int bSize = replaceTab(b);
        
        if (aSize != bSize) {
            return false;
        }
        
        for (int i = 0; i < aSize; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private int replaceTab(char[] tab) {
        int write = 0;
        
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == '#') {
                if (write > 0) {
                    --write;   
                }
            } else {
                tab[write++] = tab[i]; 
            }
        }
        
        return write;
    }
}