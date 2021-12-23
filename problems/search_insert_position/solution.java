class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        
        int middle = ((right - left) / 2) + left;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return search(nums, target, left, middle - 1);
        } else {
            return search(nums, target, middle + 1, right);
        }
    }
}

// [1,3,5,10]