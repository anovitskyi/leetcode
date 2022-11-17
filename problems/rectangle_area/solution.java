class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int[][] a = prepareRect(ax1, ay1, ax2, ay2);
        int[][] b = prepareRect(bx1, by1, bx2, by2);

        return computeArea(a) + computeArea(b) - intersectedArea(a, b);
    }

    private int computeArea(int[][] rect) {
        int width = rect[1][0] - rect[0][0];
        if (width < 0) {
            return 0;
        }

        int length = rect[1][1] - rect[0][1];
        if (length < 0) {
            return 0;
        }

        return width * length;
    }

    private int intersectedArea(int[][] rectA, int[][] rectB) {
        int[][] intersection = prepareRect(Math.max(rectA[0][0], rectB[0][0]), Math.max(rectA[0][1], rectB[0][1]), Math.min(rectA[1][0], rectB[1][0]), Math.min(rectA[1][1], rectB[1][1]));
        return computeArea(intersection);
    }

    private int[][] prepareRect(int x1, int y1, int x2, int y2) {
        int[][] rect = {
            {x1, y1},
            {x2, y2}
        };

        return rect;
    }
}