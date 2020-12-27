class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int q = map.getOrDefault(nums[i], 0);
            map.put(nums[i], q + 1);
            copy[i] = nums[i];
        }
        
        Arrays.sort(copy, (a, b) -> {
            int diff = map.get(a) - map.get(b);
            
            if (diff == 0) {
                return b - a;
            }
            
            return diff;
        });
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = copy[i];
        }
        
        return nums;
    }
}