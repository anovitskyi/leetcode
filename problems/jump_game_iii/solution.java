class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] == Integer.MIN_VALUE) {
            return false;
        }
        
        if (arr[start] == 0) {
            return true;
        }
        
        int step = arr[start];
        arr[start] = Integer.MIN_VALUE;
        return canReach(arr, start - step) || canReach(arr, start + step);
    }
}