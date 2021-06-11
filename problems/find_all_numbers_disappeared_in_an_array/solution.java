class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] copy = new boolean[nums.length];
        for (int num : nums) {
            copy[num - 1] = true;
        }
        
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; ++i) {
            if (copy[i - 1] == false) {
                result.add(i);
            }
        }
        return result;
    }
}