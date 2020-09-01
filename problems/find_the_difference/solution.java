class Solution {
    public char findTheDifference(String s, String t) {
        char[] sTab = s.toCharArray();
        char[] tTab = t.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < sTab.length; ++i) {
            sum += tTab[i];
            sum -= sTab[i];
        }
        
        sum += tTab[tTab.length - 1];
        
        return (char) sum;
    }
}