class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> {
            double first = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
            double second = Math.sqrt(b[0] * b[0] + b[1] * b[1]);
            
            return Double.compare(first, second);
        });
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; ++i) {
            res[i] = points[i];
        }
        return res;
    }
}