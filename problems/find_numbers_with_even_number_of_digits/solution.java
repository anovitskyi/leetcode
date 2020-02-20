class Solution {
    
    public int findNumbers(int[] nums) {
        int counter = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            int digits = calculateNumberOfDigits(nums[i]);
            if (digits % 2 == 0) {
                ++counter;
            }
        }
        
        return counter;
    }
    
    private int calculateNumberOfDigits(int num) {
        int counter = 0;
        
        while (num > 0) {
            ++counter;
            num /= 10;
        }
        
        return counter;
    }
}