class Solution {
    
    public int findDuplicate(int[] nums) {
        boolean[] prev = new boolean[nums.length];
        for (int num : nums) {
            if (prev[num - 1]) {
                return num;
            }
            prev[num - 1] = true;
        }
        
        return -1;
    }
    
    // public int findDuplicate(int[] nums) {
//         for (int i = 0; i < nums.length; ++i) {
//             if (nums[i] == nums[nums[i] - 1]) {
//                 if (nums[i] - 1 != i) {
//                     return nums[i];
//                 }
//             } else {
//                 int index = nums[i] - 1;
//                 int copy = nums[i];
//                 nums[i] = nums[index];
//                 nums[index] = copy;
//             }
//         }
        
//         return -1;
//     }
}