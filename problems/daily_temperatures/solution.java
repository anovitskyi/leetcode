class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        
        for (int i = res.length - 1; i >= 0; --i) {
            for (int j = i + 1; j < res.length; ++j) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        
        return res;
    }
}