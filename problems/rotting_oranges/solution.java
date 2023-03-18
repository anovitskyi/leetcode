class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                } else if (grid[i][j] == 1) {
                    ++freshOranges;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            while (size-- > 0) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    --freshOranges;
                    queue.offer(new int[] {x - 1, y});
                }

                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    --freshOranges;
                    queue.offer(new int[] {x + 1, y});
                }
                
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    --freshOranges;
                    queue.offer(new int[] {x, y - 1});
                }
                
                if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    --freshOranges;
                    queue.offer(new int[] {x, y + 1});
                }
            }

            ++minutes;
        }

        if (freshOranges != 0) {
            return -1;
        }
        return minutes;
    }
}