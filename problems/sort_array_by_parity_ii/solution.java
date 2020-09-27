class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 0;
        int even = 1;
        int[] res = new int[A.length];
        
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                res[odd] = A[i];
                odd += 2;
            } else {
                res[even] = A[i];
                even += 2;
            }
        }
        
        return res;
    }
}