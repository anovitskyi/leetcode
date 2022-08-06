class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> busMap = new HashMap<>();
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            Set<Integer> routeSet = new HashSet<>();
            busMap.put(i, routeSet);
            
            for (int j = 0; j < routes[i].length; ++j) {
                routeSet.add(routes[i][j]);
                routeMap.computeIfAbsent(routes[i][j], x -> new HashSet<>()).add(i);
            }
        }
        
        boolean[] visitedBuses = new boolean[routes.length];
        
        Queue<Integer> queue = new LinkedList<>();
        int result = 1;
        
        for (int sourceBus : routeMap.get(source)) {
            queue.offer(sourceBus);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int bus = queue.poll();
                
                if (visitedBuses[bus]) {
                    continue;
                }
                visitedBuses[bus] = true;
                
                Set<Integer> busRoutes = busMap.get(bus);
                for (int route : busRoutes) {
                    if (route == target) {
                        return result;
                    }
                    
                    Set<Integer> connectedBuses = routeMap.get(route);
                    for (int b : connectedBuses) {
                        if (b != bus && !visitedBuses[b]) {
                            queue.offer(b);
                        }
                    }
                }
            }
            ++result;
        }
        
        return -1;
    }
}