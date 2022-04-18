class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        
        visit(0, rooms, visited);
        
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void visit(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) {
            return;
        }
        
        visited[room] = true;
        
        List<Integer> keys = rooms.get(room);
        for (int key : keys) {
            visit(key, rooms, visited);
        }
    }
}