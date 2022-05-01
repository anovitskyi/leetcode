class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    skipS++; 
                    sPointer--;
                } else if (skipS > 0) {
                    skipS--; 
                    sPointer--;
                } else {
                    break;
                }
            }
            
            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    skipT++; 
                    tPointer--;
                } else if (skipT > 0) {
                    skipT--; 
                    tPointer--;
                } else {
                    break;
                }
            }
            
            if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }
            
            if ((sPointer >= 0) != (tPointer >= 0)) {
                return false;
            }
            
            sPointer--;
            tPointer--;
        }
        
        return true;
    }
}