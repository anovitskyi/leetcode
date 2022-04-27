class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                ++counter;
            } else {
                --counter;
            }
        }
        
        return candidate;
    }
}