class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        
        int initColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (image[x][y] != initColor) {
                continue;
            }
            image[x][y] = color;
            
            if (x - 1 >= 0 && image[x - 1][y] == initColor) {
                queue.offer(new int[] {x - 1, y});
            }
            
            if (x + 1 < image.length && image[x + 1][y] == initColor) {
                queue.offer(new int[] {x + 1, y});
            }
            
            if (y - 1 >= 0 && image[x][y - 1] == initColor) {
                queue.offer(new int[] {x, y - 1});
            }
            
            if (y + 1 < image[x].length && image[x][y + 1] == initColor) {
                queue.offer(new int[] {x, y + 1});
            }
        }
        
        return image;
    }
}