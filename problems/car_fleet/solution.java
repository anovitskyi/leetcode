class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indexes = new Integer[speed.length];
        for (int i = 0; i < indexes.length; ++i) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> position[b] - position[a]);
        
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < indexes.length; ++i) {
            int carDistance = target - position[indexes[i]];
            int carSpeed = speed[indexes[i]];
            double carTime = (carDistance * 1.0d) / carSpeed; 

            if (stack.isEmpty() || Double.compare(stack.peek(), carTime) < 0) {
                stack.push(carTime);
            }
        }
        return stack.size();
    }
}