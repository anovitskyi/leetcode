class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] > nums[right]) {
            int tmpL = left;
            int tmpR = right;
            int pivot = -1;
            
            while (tmpL <= tmpR) {
                int mid = (tmpR - tmpL) / 2 + tmpL;

                if (nums[mid] <= nums[right]) {
                    tmpR = mid - 1;
                } else {
                    pivot = mid;
                    tmpL = mid + 1;
                }
            }

            if (target >= nums[left]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

/*
           |       
    [1, 2, 3, 0]



















 */