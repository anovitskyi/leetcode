class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        
        int max = 0;
        for (int i = 1; i < A.length - 1; ++i) {
            if (A[i - 1] >= A[i] || A[i] <= A[i + 1]) {
                continue;
            }
            
            int left = i - 1;
            while (left - 1 >= 0 && A[left - 1] < A[left]) {
                --left;
            }
            
            int right = i + 1;
            while (right + 1 < A.length && A[right + 1] < A[right]) {
                ++right;
            }
            
            max = Math.max(max, 1 + (i - left) + (right - i));
            i = right;
        }
        return max;
    }
}