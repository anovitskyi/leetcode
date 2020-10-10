class Solution {
    public int findSpecialInteger(int[] arr) {
        int quarter = (int) (arr.length * 0.25);
        
        for (int i = 0; i < arr.length - quarter; ++i) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }
        
        return -1;
    }
}

// [1,1,1,1,2,3,4,5]