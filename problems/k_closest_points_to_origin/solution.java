class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double aDist = Math.sqrt((a[0] * a[0]) + (a[1] * a[1]));
            double bDist = Math.sqrt((b[0] * b[0]) + (b[1] * b[1]));

            return Double.compare(bDist, aDist);
        });

        for (int[] point : points) {
            heap.offer(point);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = heap.poll();
        }
        return result;
    }
}