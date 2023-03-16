class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Point> pacificPoints = findPacificPoints(heights);
        Set<Point> atlanticPoints = findAtlanticPoints(heights);

        List<List<Integer>> result = new ArrayList<>();
        for (Point pacificPoint : pacificPoints) {
            if (!atlanticPoints.contains(pacificPoint)) {
                continue;
            }

            result.add(List.of(pacificPoint.x, pacificPoint.y));
        }
        return result;
    }

    private Set<Point> findPacificPoints(int[][] heights) {
        Set<Point> pacificPoints = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(0, 0));
        for (int x = 1; x < heights.length; ++x) {
            queue.offer(new Point(x, 0));
        }
        for (int y = 1; y < heights[0].length; ++y) {
            queue.offer(new Point(0, y));
        }

        traverseIsland(heights, queue, pacificPoints);

        return pacificPoints;
    }

    private Set<Point> findAtlanticPoints(int[][] heights) {
        Set<Point> atlanticPoints = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        int xLast = heights.length - 1;
        int yLast = heights[0].length - 1;
        
        queue.offer(new Point(xLast, yLast));
        for (int x = xLast - 1; x >= 0; --x) {
            queue.offer(new Point(x, yLast));
        }
        for (int y = yLast - 1; y >= 0; --y) {
            queue.offer(new Point(xLast, y));
        }

        traverseIsland(heights, queue, atlanticPoints);

        return atlanticPoints;
    }

    private void traverseIsland(int[][] heights, Queue<Point> queue, Set<Point> visitedPoints) {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (visitedPoints.contains(point)) {
                continue;
            }
            visitedPoints.add(point);

            int x = point.x;
            int y = point.y;

            if (x - 1 >= 0 && heights[x - 1][y] >= heights[x][y]) {
                queue.offer(new Point(x - 1, y));
            }

            if (x + 1 < heights.length && heights[x + 1][y] >= heights[x][y]) {
                queue.offer(new Point(x + 1, y));
            }

            if (y - 1 >= 0 && heights[x][y - 1] >= heights[x][y]) {
                queue.offer(new Point(x, y - 1));
            }

            if (y + 1 < heights[x].length && heights[x][y + 1] >= heights[x][y]) {
                queue.offer(new Point(x, y + 1));
            }
        }
    }

    private static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            Point oPoint = (Point)other;
            return this.x == oPoint.x && this.y == oPoint.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}