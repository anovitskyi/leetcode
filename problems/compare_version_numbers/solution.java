class Solution {
    public int compareVersion(String version1, String version2) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < version1.length() || i2 < version2.length()) {
            int v1 = 0;
            while (i1 < version1.length() && version1.charAt(i1) != '.') {
                v1 = v1 * 10 + (version1.charAt(i1) - '0');
                ++i1;
            }
            
            int v2 = 0;
            while (i2 < version2.length() && version2.charAt(i2) != '.') {
                v2 = v2 * 10 + (version2.charAt(i2) - '0');
                ++i2;
            }
            
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            
            ++i1;
            ++i2;
        }
        
        return 0;
    }
}