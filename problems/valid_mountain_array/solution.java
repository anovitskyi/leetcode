class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        int counter = 0;
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i - 1] == arr[i] || arr[i + 1] == arr[i]) {
                return false;
            }
            
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                return false;
            }
            
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                if (counter > 0) {
                    return false;
                }
                ++counter;
            }
            
        }
        
        return counter == 1;
    }
}