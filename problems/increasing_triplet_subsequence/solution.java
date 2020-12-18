class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        int f = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;
        int t = Integer.MAX_VALUE;
        
        for (int n : nums) {
            if (n <= f) {
                f = n;
            } else if (n <= s) {
                s = n;
            } else if (n <= t) {
                return true;
            }
        }
        
        return false;
    }
}