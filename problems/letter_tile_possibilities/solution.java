class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        findPerms(tiles, set, visited, "");
        return set.size();
    }
    
    private void findPerms(String tiles, Set<String> prev, boolean[] visited, String current) {
        if (current.length() == tiles.length()) {
            return;
        }
        
        for (int i = 0; i < tiles.length(); ++i) {
            if (!visited[i]) {
                visited[i] = true;
                String next = current + tiles.charAt(i);
                prev.add(next);
                findPerms(tiles, prev, visited, next);
                visited[i] = false;
            }
        }
    }
}