class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int result = -1;
        
        for (int num : nums) {
            if (counter == 0) {
                result = num;
                counter = 1;
            } else if (num == result) {
                ++counter;
            } else {
                --counter;
            }
        }
        
        return result;
    }
}