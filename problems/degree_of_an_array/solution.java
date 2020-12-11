class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = -1;
        Map<Integer, Group> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            final int index = i;
            Group group = map.computeIfAbsent(nums[i], key -> new Group(index));
            group.end = i;
            if (max < ++group.counter) {
                max = group.counter;
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (Group group : map.values()) {
            if (group.counter == max) {
                int currDiff = group.end + 1 - group.start;
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                }
            }
        }
        return minDiff;
    }
    
    private class Group {
        int start;
        int end;
        int counter;
        
        Group(int start) {
            this.start = start;
            this.end = start;
            this.counter = 0;
        }
    }
}