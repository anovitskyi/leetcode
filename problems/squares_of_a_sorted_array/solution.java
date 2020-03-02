class Solution {
    public int[] sortedSquares(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] >= 0) {
                index = i;
                break;
            }
        }
    
        
        int[] negative = getSquares(A, 0, index);
        int[] positive = getSquares(A, index, A.length);
        
        int n = negative.length - 1;
        int p = 0;
        
        int[] res = new int[A.length];
        int i;
        for (i = 0; i < A.length && n >= 0 && p < positive.length; ++i) {
            if (negative[n] <= positive[p]) {
                res[i] = negative[n--];
            } else {
                res[i] = positive[p++];
            }
        }
        
        if (n >= 0) {
            for (; n >= 0; ++i) {
                res[i] = negative[n--];
            }
        } else if (p < positive.length) {
            for (; p < positive.length; ++i) {
                res[i] = positive[p++];
            }
        }
        
        return res;
    }
    
    private static int[] getSquares(int[] arr, int start, int finish) {
        int[] res = new int[finish - start];
        
        for (int i = start; i < finish; ++i) {
            res[i - start] = arr[i] * arr[i];
        }
        
        return res;
    }
}