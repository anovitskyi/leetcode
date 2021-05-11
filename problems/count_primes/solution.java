class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int result = 0;
        int end = (int) Math.sqrt(n);
        
        for (int i = 2; i <= end; ++i) {
            for (int j = i + i; j < n; j += i) {
                arr[j] = true;
            }
        }
        
        for (int i = 2; i < n; ++i) {
            if (!arr[i]) {
                ++result;
            }
        }
        
        return result;
        
    }

}