class Solution {
    public int minStartValue(int[] nums) {
        int i = 1;
        while (true) {
            int sum = i;
            boolean found = true;
            for (int j = 0; j < nums.length; ++j) {
                sum += nums[j];
                if (sum < 1) {
                    found = false;
                    break;
                }
            }
            
            if (found) {
                return i;
            }
            
            ++i;
        }
    }
}
// -3 2 -3 4 2
// -3 -1 -4 0 2