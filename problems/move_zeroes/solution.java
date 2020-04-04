class Solution {
    public void moveZeroes(int[] nums) {
//         int counter = 0;
//         for (int i = 0; i < nums.length; ++i) {
//             if (nums[i] != 0) {
//                 nums[counter++] = nums[i];
//             }
//         }
        
//         for (; counter < nums.length; ++counter) {
//             nums[counter] = 0;
//         }
        
        int i=0, j=0;
        while(i < nums.length){
            if(nums[i] == 0) {
                j = i;

                while(j < nums.length && nums[j] == 0){
                    j++;
                }

                if(j == nums.length) return;

                nums[i] = nums[j];
                nums[j] = 0;
                
                j = i;
            } else {
                ++i;
            }
        }
    }
}