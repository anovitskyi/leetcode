class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int counter = 0;
        
        for (int num : arr1) {
            int min = num - d;
            int max = num + d;
            int left = 0;
            int right = arr2.length - 1;
            int middle;
            boolean found = false;
            
            while (left <= right) {
                middle = (right - left) / 2 + left;
                if (arr2[middle] >= min && arr2[middle] <= max) {
                    found = true;
                    break;
                } else if (arr2[middle] >= max) {
                    right = middle - 1;
                } else if (arr2[middle] <= min) {
                    left = middle + 1;
                }
            }
            
            if (!found) {
                ++counter;
            }
        }
        
        return counter;
    }
}