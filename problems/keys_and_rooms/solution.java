class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        }
        
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int number, boolean[] visited) {
        visited[number] = true;
        
        for (int key : rooms.get(number)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);   
            }
        }
    }
}