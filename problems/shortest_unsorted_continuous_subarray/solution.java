class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] unsortedPoints = findUnsortedPoints(nums);
        
        if (unsortedPoints[0] == Integer.MAX_VALUE) {
            return 0;
        }
        
        return findAppropriateMaxPosition(unsortedPoints[1], nums) - findAppropriateMinPosition(unsortedPoints[0], nums) + 1;
    }
    
    private int findAppropriateMinPosition(int min, int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > min) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int findAppropriateMaxPosition(int max, int[] nums) {
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < max) {
                return i;
            }
        }
        
        return -1;
    }
    
    private int[] findUnsortedPoints(int[] nums) {
        int[] result = new int[] {
            Integer.MAX_VALUE,
            Integer.MIN_VALUE
        };
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > nums[i]) {
                result[0] = Math.min(result[0], nums[i]);
                result[1] = Math.max(result[1], nums[i - 1]);
            }
        }
        
        return result;
    }
}

/*
    
    [5, 6, 7, 1, 90, 8, 9]
    [5, 6, 7, 90, 80, 8, 9]
    [1, 2, 3, 4]
    
    1. Find unsorted minimum element in array
    2. Find unsorted maximum element in array
    3. Find appropriate position for minimum in the array
    4. Find appropriate position for maximum in the array
    5. Return the difference of appropriate positions

*/