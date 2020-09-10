class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int length = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < length; ++i) {
            int f = 0;
            int s = 0;
            
            if (i < v1.length) {
                f = Integer.parseInt(v1[i]);
            }
            
            if (i < v2.length) {
                s = Integer.parseInt(v2[i]);
            }
            
            if (f != s) {
                return f > s ? 1 : -1;
            }
        }
        
        return 0;
    }
}