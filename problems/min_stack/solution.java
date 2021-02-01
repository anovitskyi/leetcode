class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }
    
    public void pop() {
        if (min.peek().equals(stack.peek())) {
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        int res = stack.peek();
        return res;
    }
    
    public int getMin() {
        int res = min.peek();
        return res;
    }
}