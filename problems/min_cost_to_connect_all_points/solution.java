class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] {0, 0});

        while (visited.size() < points.length) {
            int[] next = queue.poll();
            int dist = next[0];
            int point = next[1];

            if (visited.contains(point)) {
                continue;
            }
            visited.add(point);
            result += dist;

            for (int nextPoint = 0; nextPoint < points.length; ++nextPoint) {
                if (nextPoint == point) {
                    continue;
                }

                int nextDist = Math.abs(points[nextPoint][0] - points[point][0]) + Math.abs(points[nextPoint][1] - points[point][1]);

                queue.offer(new int[] {nextDist, nextPoint});
            } 
        }

        return result;
    }
}