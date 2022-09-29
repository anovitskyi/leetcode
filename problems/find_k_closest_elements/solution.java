class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = k;
        
        while (right < arr.length) {
            int diff = Math.abs(arr[left] - x) - Math.abs(arr[right] - x);
            
            if (diff < 0) {
                break;
            } else if (diff > 0) {
                ++right;
                left = right - k;
            } else {
                ++right;
            }
        }
        
        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; ++i) {
            result.add(arr[i]);
        }
        return result;
    }
}