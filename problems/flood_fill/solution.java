class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        dfs(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int newColor, int prevColor) {
        if (x < 0 || x >= image.length) {
            return;
        }
        
        if (y < 0 || y >= image[x].length) {
            return;
        }
        
        if (image[x][y] != prevColor) {
            return;
        }
        
        image[x][y] = newColor;
        dfs(image, x - 1, y, newColor, prevColor);
        dfs(image, x + 1, y, newColor, prevColor);
        dfs(image, x, y - 1, newColor, prevColor);
        dfs(image, x, y + 1, newColor, prevColor);
    }
}