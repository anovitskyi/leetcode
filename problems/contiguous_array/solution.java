class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 0);
        for (int i = 0; i < nums.length; i++) {
            ++count;
            if (nums[i] == 0) sum--;
            else if (nums[i] == 1) sum++;
            if (map.get(sum) == null) map.put(sum, count);
            else {
                int interval = count - map.get(sum);
                if (interval > max) max = interval;
            }
        }
        return max;
    }
}