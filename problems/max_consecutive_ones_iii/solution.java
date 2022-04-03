class Solution {
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int left = 0;
        int right = 0;
        int[] counters = new int[2];
        
        while (right < A.length) {
            if (counters[0] <= K) {
                ++counters[A[right++]];
            } else {
                --counters[A[left++]];
            }
            
            if (counters[0] <= K) {
                result = Math.max(result, right - left);
            }
        }
        
        return result;
    }
}