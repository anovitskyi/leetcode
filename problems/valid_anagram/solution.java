class Solution {
    public boolean isAnagram(String s, String t) {    
        if (s.length() != t.length()) {
            return false;
        }
        char[] sTab = s.toCharArray();
        char[] tTab = t.toCharArray();
        Arrays.sort(sTab);
        Arrays.sort(tTab);
        
        for (int i = 0; i < sTab.length; ++i) {
            if (sTab[i] != tTab[i]) {
                return false;
            }
        }
        return true;
    }
}