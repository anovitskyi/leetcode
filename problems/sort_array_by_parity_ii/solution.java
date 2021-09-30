class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        
        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 != 0 && nums[odd] % 2 != 1) {
                int tmp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = tmp;
            }
            
            if (nums[even] % 2 == 0) {
                even += 2;
            }
            
            if (nums[odd] % 2 == 1) {
                odd += 2;
            }
        }
        
        return nums;
    }
}

// [2,3,0,1,4,1,0,3,4,3]
//  0 1 2 3 4 5 6 7 8 9
// even = 10
// odd = 9