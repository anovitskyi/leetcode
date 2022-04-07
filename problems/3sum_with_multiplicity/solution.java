class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int result = 0;
        int mod = 1_000_000_007;
        
        for (int i = 0; i < arr.length - 2; ++i) {
            result = (result + findTwoSums(arr, i + 1, arr.length - 1, target - arr[i])) % mod;
        }
        
        return result;
    }
    
    private int findTwoSums(int[] arr, int left, int right, int target) {
        int result = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum < target) {
                ++left;
            } else if (sum > target) {
                --right;
            } else if (arr[left] != arr[right]) {
                int li = left;
                int leftOccurrences = 1;
                while (left + 1 < right && arr[left + 1] == arr[li]) {
                    ++left;
                    ++leftOccurrences;
                }
                
                int ri = right;
                int rightOccurrences = 1;
                while (left < right - 1 && arr[right - 1] == arr[ri]) {
                    --right;
                    ++rightOccurrences;
                }
                
                result += leftOccurrences * rightOccurrences;
                ++left;
                --right;
            } else {
                int n = right - left + 1;
                int r = 2;
                int binom = n * (n - 1) / 2;
                result += binom;
                break;
            }
        }
        return result;
    }
}
