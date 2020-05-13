class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int sum = 0;
//         int factor = 1;
        
//         for (int i = 0; i < nums.length; ++i) {
//             sum += factor * nums[i];
//             factor *= -1;
//         }
        
//         return Math.abs(sum);
//     }
    
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        
        for (int num : nums) {
            ans ^= num;
        }
        
        return ans;
    }
}