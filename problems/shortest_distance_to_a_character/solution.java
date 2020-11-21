class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                set.add(i);
            }
        }
        
        int[] res = new int[S.length()];
        int right = 0;
        int left = Integer.MAX_VALUE;
        
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                left = right;
                ++right;
            } else {
                int leftDiff = left >= set.size() ? Integer.MAX_VALUE : Math.abs(i - set.get(left));
                int rightDiff = right >= set.size() ? Integer.MAX_VALUE : Math.abs(i - set.get(right));
                
                res[i] = Math.min(leftDiff, rightDiff);
            }
        }
        
        return res;
    }
}