class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeros = 0;
        int zeroIndex = -1;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++zeros;
                zeroIndex = i;
            } else {
                prod *= nums[i];
            }
        }
        
        int[] output = new int[nums.length];
        if (zeros == 1) {
            output[zeroIndex] = prod;    
        } else if (zeros == 0) {
            for (int i = 0; i < output.length; ++i) {
                output[i] = prod / nums[i];
            }
        }
        
        return output;
    }
}