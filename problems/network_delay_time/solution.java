class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<Destination>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0] - 1, node -> new TreeSet<>())
                .add(new Destination(time[1] - 1, time[2]));
        }
        
        int[] signalTimes = new int[n];
        for (int i = 0; i < n; ++i) {
            signalTimes[i] = Integer.MAX_VALUE;
        }
        signalTimes[k - 1] = 0;
        
        traverseNodes(graph, k - 1, signalTimes);
        
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (i != k - 1 && signalTimes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            
            result = Math.max(result, signalTimes[i]);
        }
        return result;
    }
    
    private void traverseNodes(Map<Integer, Set<Destination>> graph, int node, int[] signalTimes) {
        Set<Destination> destinations = graph.get(node);
        if (destinations == null) {
            return;
        }
        
        int currSignalTime = signalTimes[node];
        for (Destination dest : destinations) {
            if (dest.time + currSignalTime >= signalTimes[dest.node]) {
                continue;
            }
            
            signalTimes[dest.node] = dest.time + currSignalTime;
            traverseNodes(graph, dest.node, signalTimes);
        }
    }
    
    private class Destination implements Comparable<Destination> {
        final int node;
        final int time;
        
        Destination(int node, int time) {
            this.node = node;
            this.time = time;
        }
        
        @Override
        public int compareTo(Destination other) {
            int diff = time - other.time;
            
            if (diff == 0) {
                return node - other.node;
            }
            
            return diff;
        }
        
        @Override
        public String toString() {
            return "[" + node + ", " + time + "]";
        }
    }
}