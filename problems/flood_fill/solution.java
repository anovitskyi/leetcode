class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            fill(image, sr, sc, image[sr][sc], color);
        }
        
        return image;
    }
    
     private void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if (sr < 0 || sr >= image.length) {
            return;
        }
        
        if (sc < 0 || sc >= image[sr].length) {
            return;
        }
         
        if (image[sr][sc] != originalColor) {
             return;
        }
        
        image[sr][sc] = newColor;
        fill(image, sr - 1, sc, originalColor, newColor);
        fill(image, sr + 1, sc, originalColor, newColor);
        fill(image, sr, sc - 1, originalColor, newColor);
        fill(image, sr, sc + 1, originalColor, newColor);
    }
}