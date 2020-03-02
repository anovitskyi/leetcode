class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = nums.clone();
        int[] res = new int[copy.length];
        
        Arrays.sort(nums);
        
        for (int i = 0; i < copy.length; ++i) {
            for (int j = 0; j < copy.length; ++j) {
                if (nums[j] >= copy[i]) {
                    res[i] = j;
                    break;
                }
            }
        }
        
        return res;
    }
} 