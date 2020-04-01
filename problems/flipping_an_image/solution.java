class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            int[] arr = A[i];
            int size = arr.length;
            for (int j = 0; j < size / 2; ++j) {
                arr[j] = 1 - arr[j];
                arr[size - j - 1] = 1 - arr[size - j - 1];
                
                int tmp = arr[j];
                arr[j] = arr[size - j - 1];
                arr[size - j - 1] = tmp;
            }
            
            if (size % 2 == 1) {
                arr[size / 2] = 1 - arr[size / 2];
            }
        }
        
        return A;
    }
}