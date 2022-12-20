class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>(rooms.size());
        visit(rooms, 0, visited);

        for (int i = 0; i < rooms.size(); ++i) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private void visit(List<List<Integer>> rooms, int curr, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return;
        }
        visited.add(curr);

        for (int key : rooms.get(curr)) {
            visit(rooms, key, visited);
        }
    }
}