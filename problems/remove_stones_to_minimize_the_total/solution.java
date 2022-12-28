class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int pile : piles) {
            queue.offer(pile);
            sum += pile;
        }

        for (int i = 0; i < k; ++i) {
            int pile = queue.poll();
            int div = pile / 2;
            pile -= div;
            queue.offer(pile);
            sum -= div;
        }

        return sum;
    }
}