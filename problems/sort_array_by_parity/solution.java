class Solution {
    public int[] sortArrayByParity(int[] A) {
        int pointer = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                int tmp = A[i];
                A[i] = A[pointer];
                A[pointer++] = tmp;
            }
        }
        
        return A;
    }
}