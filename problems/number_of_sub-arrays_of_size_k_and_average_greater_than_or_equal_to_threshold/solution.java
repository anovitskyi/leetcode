class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int averageSum = k * threshold;
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }
        
        int result = 0;
        for (int i = k; i < arr.length; ++i) {
            if (sum >= averageSum) {
                ++result;
            }
            
            sum -= arr[i - k];
            sum += arr[i];
        }
        if (sum >= averageSum) {
            ++result;
        }
        
        return result;
    }
}