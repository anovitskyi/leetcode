class Solution {
    public boolean canJump(int[] nums) {
        int[] visited = new int[nums.length];
        return canReachLastElement(0, nums, visited);
    }
    
    private boolean canReachLastElement(int index, int[] nums, int[] visited) {
        if (index >= nums.length - 1 || visited[index] == 1) {
            return true;
        }
        
        if (visited[index] == -1) {
            return false;
        }
        
        for (int i = nums[index]; i >= 1; --i) {
            if (canReachLastElement(index + i, nums, visited)) {
                visited[index] = 1;
                return true;
            }
        }
        
        visited[index] = -1;
        return false;
    }
}

/*

    
    [2,3,1,1,4]
    [0,0,0,0,0]

*/