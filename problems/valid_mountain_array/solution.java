class Solution {
    public boolean validMountainArray(int[] arr) { // 0 7 5
        if (arr.length < 3) {
            return false;
        }
        
        boolean isIncreasing = true;
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            
            if ((arr[i] < arr[i + 1]) != isIncreasing) {
                if (isIncreasing == true && i > 0) {
                    isIncreasing = false;
                    continue;
                }
                return false;
            }
        }
        
        return isIncreasing == false;
    }
}