class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] tab = S.toCharArray();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < tab.length; ++i) {
            if (tab[i] == C) {
                set.add(i);
            }
        }
        
        int[] res = new int[tab.length];
        for (int i = 0; i < tab.length; ++i) {
            int min = Integer.MAX_VALUE;
            for (int index : set) {
                int diff = Math.abs(i - index);
                if (diff < min) {
                    min = diff;
                }
            }
            res[i] = min;
        }
        return res;
    }
}