class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            long product = 1;
            for (int j = i; j < nums.length; ++j) {
                product *= nums[j];
                if (product < k) {
                    ++result;
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}

/*

 result = 2
 product = 100
 k = 100

     |
 [10,5,2,6]
     |
*/