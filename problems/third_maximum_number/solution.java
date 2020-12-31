class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        int distinct = 0;
        
        for (int num : nums) {
            if (num != first && num != second && num != third) {
                ++distinct;
            
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } else if (num > second) {
                    third = second;
                    second = num;
                } else if (num > third) {
                    third = num;
                }
            }
        }
        
        if (distinct < 3) {
            return (int) first;
        }
        
        return (int) third;
    }
}