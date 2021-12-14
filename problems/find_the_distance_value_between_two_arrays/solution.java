class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        for (int num : arr1) {
            if (!hasDistance(arr2, num - d, num + d, 0, arr2.length - 1)) {
                ++result;
            }
        }
        return result;
    }
    
    private boolean hasDistance(int[] nums, int leftNum, int rightNum, int left, int right) {
        if (left > right) {
            return false;
        }
        
        int middle = ((right - left) / 2) + left;
        if (nums[middle] >= leftNum && nums[middle] <= rightNum) {
            return true;
        } else if (nums[middle] > rightNum) {
            return hasDistance(nums, leftNum, rightNum, left, middle - 1);
        } else {
            return hasDistance(nums, leftNum, rightNum, middle + 1, right);
        }
    }
}

// [1,8,9,10]