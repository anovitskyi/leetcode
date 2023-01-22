class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            int currResult = 1;
            int target = num + 1;
            while (set.contains(target)) {
                ++target;
                ++currResult;
            }
            
            if (currResult > result) {
                result = currResult;
            }
        }

        return result;
    }
}