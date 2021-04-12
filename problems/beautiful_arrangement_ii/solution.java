class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int left = 1;
        int right = k + 1;
        int index = 0;
        
        while (left < right) {
            result[index++] = left++;
            result[index++] = right--;
        }
        
        if (left == right) {
            result[index++] = left;
        }
        
        ++k;
        while (++k <= n) {
            result[index++] = k;
        }
        
        return result;
    }
}