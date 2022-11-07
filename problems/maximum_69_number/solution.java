class Solution {
    public int maximum69Number (int num) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int result = 0;
        boolean replaced = false;
        while (!stack.isEmpty()) {
            result *= 10;
            int last = stack.pop();
            if (last == 6 && !replaced) {
                last = 9;
                replaced = true;
            }
            result += last;
        }
        return result;
    }
}