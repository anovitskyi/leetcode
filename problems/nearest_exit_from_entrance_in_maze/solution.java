class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                
                int x = cell[0];
                if (x < 0 || x >= maze.length) {
                    continue;
                }
                
                int y = cell[1];
                if (y < 0 || y >= maze[x].length) {
                    continue;
                }

                if (maze[x][y] == '+') {
                    continue;
                }
                maze[x][y] = '+';

                if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[x].length - 1) {
                    if (x != entrance[0] || y != entrance[1]) {
                        return result;
                    }
                }

                queue.offer(new int[] {x - 1, y});
                queue.offer(new int[] {x + 1, y});
                queue.offer(new int[] {x, y - 1});
                queue.offer(new int[] {x, y + 1});
            }
            ++result;
        }

        return -1;
    }
}