class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < isConnected.length; ++i) {
            Set<Integer> cities = map.computeIfAbsent(i, city -> new HashSet<>());
            for (int j = 0; j < isConnected[i].length; ++j) {
                if (isConnected[i][j] == 1 && i != j) {
                    cities.add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i]) {
                continue;
            }        
            
            ++result;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            
            while (!queue.isEmpty()) {
                for (int city : map.get(queue.poll())) {
                    if (!visited[city]) {
                        queue.offer(city);
                        visited[city] = true;
                    }
                }
            }
        }
        
        return result;
    }
}