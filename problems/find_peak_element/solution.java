class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            long curr = nums[middle];
            long prev = middle - 1 >= 0 ? nums[middle - 1] : Long.MIN_VALUE;
            long next = middle + 1 < nums.length ? nums[middle + 1] : Long.MIN_VALUE;
            
            if (prev < curr && curr > next) {
                return middle;
            } else if (prev > curr) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return -1;
    }
}