class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder b = new StringBuilder();
        
        int added = k;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '-') {
                continue;
            }
            
            b.append(Character.toUpperCase(s.charAt(i)));
            
            if (--added == 0) {
                b.append('-');
                added = k;
            }
        }
        
        if (b.length() > 0 && b.charAt(b.length() - 1) == '-') {
            b.deleteCharAt(b.length() - 1);
        }
        
        return b.reverse().toString();
    }
}