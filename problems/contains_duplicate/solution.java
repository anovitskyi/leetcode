class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        for (int i = 0; i < nums.length; ++i) {
            if (map.put(nums[i], nums[i]) != null) {
                return true;
            } 
        }
        
        return false;
    }
}