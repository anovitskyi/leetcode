class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[right];
    }
}