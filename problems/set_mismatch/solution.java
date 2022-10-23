class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = (nums.length + nums.length * nums.length) / 2;
        int duplicate = -1;
        
        for (int i = 0; i < nums.length; ++i) {
            int absNum = Math.abs(nums[i]);
            
            if (nums[absNum - 1] < 0) {
                duplicate = absNum;
            } else {
                nums[absNum - 1] *= -1;
                sum -= absNum;
            }
        }
        
        return new int[] {duplicate, sum};
    }
}