class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; ++i) {
            if (!stack.isEmpty() && getDir(stack.peek()) == 1 && getDir(asteroids[i]) == -1) {
                while (!stack.isEmpty() && getDir(stack.peek()) == 1 && Math.abs(asteroids[i]) > stack.peek()) {
                    stack.pop();
                }
                
                if (!stack.isEmpty() && Math.abs(asteroids[i]) == stack.peek()) {
                    stack.pop();
                } else if (stack.isEmpty() || getDir(stack.peek()) == -1) {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
    
    private int getDir(int asteroid) {
        if (asteroid < 0) {
            return -1;
        }
        
        return 1;
    }
}