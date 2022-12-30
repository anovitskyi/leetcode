class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        int resultIndex = 0;

        int[][] copy = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            copy[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(copy, (a, b) -> a[0] - b[0]);

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int processingTimeDiff = a[1] - b[1];
            if (processingTimeDiff != 0) {
                return processingTimeDiff;
            }

            return a[2] - b[2];
        });

        int time = 0;
        for (int i = 0; i < copy.length; ++i) {
            if (queue.isEmpty()) {
                queue.offer(copy[i]);
                time = Math.max(time, copy[i][0]);
            } else {
                --i;
            }

            while (i + 1 < copy.length && time >= copy[i + 1][0]) {
                queue.offer(copy[i + 1]);
                ++i;
            }

            int[] currTask = queue.poll();
            result[resultIndex++] = currTask[2];
            time += currTask[1];
        }

        while (!queue.isEmpty()) {
            result[resultIndex++] = queue.poll()[2];
        }

        return result;
    }
}























