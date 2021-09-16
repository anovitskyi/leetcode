class MinStack {
    
    private final Stack<Integer> val = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    
    public void push(int value) {
        val.push(value);
        
        int minimum = value;
        if (!min.isEmpty() && min.peek() < minimum) {
            minimum = min.peek();
        }
        min.push(minimum);
    }
    
    public void pop() {
        val.pop();
        min.pop();
    }
    
    public int top() {
        return val.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}