class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int counter = 0;
        
        for (int k = arr.length - 1; k >= 2; --k) {
            for (int j = k - 1; j >= 1; --j) {
                int absDiff = Math.abs(arr[j] - arr[k]);
                if (absDiff <= b) {
                    for (int i = j - 1; i >= 0; --i) {
                        int absJ = Math.abs(arr[i] - arr[j]);
                        int absK = Math.abs(arr[i] - arr[k]);
                        
                        if (absJ <= a && absK <= c) {
                            ++counter;
                        }
                    }
                }
            }
        }
        
        return counter;
    }
}