class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) { // O(n + m)
        int even = 0;
        for (int i = 0; i < A.length; ++i) { // O(n)
            if (A[i] % 2 == 0) {
                even += A[i];
            }
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) { // O(m)
            int index = queries[i][1];
            int val = queries[i][0];
            
            if (A[index] % 2 == 0) {
                even -= A[index];
            }
            
            A[index] += val;
            
            if (A[index] % 2 == 0) {
                even += A[index];
            }
            
            res[i] = even;
        }
        return res;
    }
}