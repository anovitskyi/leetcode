class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        String[] res = new String[nums.length];
        
        Map<Integer, String> map = new HashMap<>(nums.length);
        for (int i = copy.length - 1; i >= 0; --i) {
            int index = copy.length - i;
            
            if (index == 1) {
                map.put(copy[i], "Gold Medal");
            } else if (index == 2) {
                map.put(copy[i], "Silver Medal");
            } else if (index == 3) {
                map.put(copy[i], "Bronze Medal");
            } else {
                map.put(copy[i], index + "");
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
}
