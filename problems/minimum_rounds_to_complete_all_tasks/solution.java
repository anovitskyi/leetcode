class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int result = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            
            result += count / 3;

            if (count % 3 != 0) {
                ++result;
            }
        }
        return result;
    }
}