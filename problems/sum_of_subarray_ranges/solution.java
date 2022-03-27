class Solution {
    public long subArrayRanges(int[] nums) {
        long result = 0L;
        
        for (int i = 0; i < nums.length; ++i) {
            int min = nums[i];
            int max = nums[i];
            
            for (int j = i + 1; j < nums.length; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                
                result += max - min;
            }
        }
        
        return result;
    }
}

/**

[1, 2, 3]

min left
[1, 1, 1]

max left
[1, 2, 3]



[1, 3, 3]

min left
[1, 1, 1]

max left
[1, 3, 3]

**/