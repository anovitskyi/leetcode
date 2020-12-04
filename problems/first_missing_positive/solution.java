class Solution {
    public int firstMissingPositive(int[] nums) { 
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
            if (num > max) {
                max = num;
            }
        }
        
        if (max <= 0) {
            return 1;
        }
        
        for (int i = 1; i <= max; ++i) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return max + 1;
    }
}