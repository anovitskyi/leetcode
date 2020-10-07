class Solution {
    public int binaryGap(int n) {
        int size = (int) (Math.log(n) / Math.log(2));
        int[] arr = new int[size + 1];
        int i = 0;
        int pos = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                arr[i++] = pos;   
            }
            
            ++pos;
            n /= 2;
        }
        
        int max = -1;
        for (int j = 1; j < size + 1; ++j) {
            int prev = arr[j] - arr[j - 1];
            if (prev > max) {
                max = prev;
            }
        }
        return Math.max(max, 0);
    }
}