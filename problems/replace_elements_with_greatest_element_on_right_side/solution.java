class Solution {
    public int[] replaceElements(int[] arr) {
        int greatest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        
        for (int i = arr.length - 2; i >= 0; --i) {
            int tmp = arr[i];
            arr[i] = Math.max(greatest, arr[i + 1]);
            greatest = tmp;
        }
        
        return arr;
    }
}