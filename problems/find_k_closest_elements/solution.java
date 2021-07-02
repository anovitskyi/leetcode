class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = k;
        
        while (right < arr.length) {
            int diff = Math.abs(arr[right] - x) - Math.abs(arr[left] - x);
            if (diff < 0) {
                left = right - k + 1;
            } else if (diff > 0) {
                break;
            }
            ++right;
        }
        
        List<Integer> result = new LinkedList<>();
        for (int i = left; i < left + k; ++i) {
            result.add(arr[i]);
        }
        return result;
    }
}