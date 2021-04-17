class Solution {
    public int arraySign(int[] nums) {
        int negativeCounter = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                ++negativeCounter;
            }
        }
        
        if (negativeCounter % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}