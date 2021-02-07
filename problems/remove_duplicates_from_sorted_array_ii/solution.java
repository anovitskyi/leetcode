class Solution {
//     public int removeDuplicates(int[] nums) {
//         int read = 1;
//         int write = 0;
        
//         while (read < nums.length) {
//             if (nums[read] != nums[write]) {
//                 if (nums[write + 1] == nums[write]) {
//                     ++write;
//                 }
//                 nums[++write] = nums[read];
//             }
        
//             ++read;
//         }
        
//         if (nums[read - 1])
//         return write + 1;
//     }
    
    public int removeDuplicates(int[] nums) {
        int read = 0;
        int write = 0;
        
        while (read < nums.length) {
            int counter = 1;
            while (read + 1 < nums.length && nums[read + 1] == nums[read]) {
                ++counter;
                ++read;
            }
            
            for (int i = 0; i < 2 && i < counter; ++i) {
                nums[write++] = nums[read];
            }
            
            ++read;
        }
        
        return write;
    }
}