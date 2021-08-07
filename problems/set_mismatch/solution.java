class Solution {
    public int[] findErrorNums(int[] nums) {
        int missing = (nums.length * (nums.length + 1)) / 2;
        int duplicate = -1;
        
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            
            if (nums[num - 1] < 0) {
                duplicate = num;
            } else {
                missing -= num;
                nums[num - 1] = 0 - nums[num - 1];
            }
        }
        
        return new int[] {
            duplicate, missing
        };
    }
}