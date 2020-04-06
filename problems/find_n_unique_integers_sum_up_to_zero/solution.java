class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        
        if (n % 2 == 1) {
            res[n - 1] = 0;
            --n;
        }
        
        for (int i = 0; i < n; i += 2) {
            int val = i + 1;
            res[i] = val;
            res[i + 1] = val * -1; 
        }
        
        return res;
    }
}