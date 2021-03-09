class Solution {
    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        int write = 0;
        int size = arr.length;
        
        for (int i = 0; i < size; ++i) {
            if (arr[i] == 0) {
                write += 2;
                --size;
            } else {
                copy[write++] = arr[i];
            }
        }
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = copy[i];
        }
    }
}