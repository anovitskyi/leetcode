class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int counter = 0;
        Arrays.sort(g);
        for (int i = 0; i < s.length; ++i) {
            for (int j = g.length - 1; j >= 0; --j) {
                if (g[j] != -1 && s[i] >= g[j]) {
                    ++counter;
                    g[j] = -1;
                    break;
                }
            }
        }
        
        return counter;
    }
}