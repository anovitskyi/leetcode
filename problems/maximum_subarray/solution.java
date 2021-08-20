class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if (sum < 0) {
                sum = 0;
            }
            
            sum += nums[i];
            
            if (sum > max) {
                max = sum;
            }
        }
        
        return max;
    }
}

// [-3,4,-1,5,-10,6,-10] -> 8

// 1. Bruteforce - O(n^2) time, O(1) space
// Two nested loops. First loop keeps index of start element. Second loop calculates elements sum starting and checks whether the sum if maximum.


// 2. Iterate array only once. Keep current sum and maximum sum. Befor adding element to sum, check whether actual sum is negative and set current sum to zero. Every time check whether current sum is maximum. Time - O(n), space - O(1)