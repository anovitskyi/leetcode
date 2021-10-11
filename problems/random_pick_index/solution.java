class Solution {
    
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            map.computeIfAbsent(nums[i], elem -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = ((int) (Math.random() * 10_000)) % list.size();
        return list.get(index);
    }
}