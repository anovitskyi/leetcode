class Solution {
    public int findDuplicate(int[] nums) {
        int index = 0;
        while (true) {
            if (nums[index] == -1) {
                return index;
            }
            int nextIndex = nums[index];
            nums[index] = -1;
            index = nextIndex;
        }
    }
}

// [1, 3, 4, 2, 2]

// i = 0, nums[0] = 1, nums = [-1, 3, 4, 2, 2]
// i = 1, nums[1] = 3, nums = [-1, -1, 4, 2, 2]
// i = 3, nums[3] = 2, nums = [-1, -1, 4, -1, 2]
// i = 2, nums[2] = 4, nums = [-1, -1, -1, -1, 2]
// i = 4, nums[4] = 2, nums = [-1, -1, -1, -1, -1]
// i = 2, nums[2] = -1, return 2