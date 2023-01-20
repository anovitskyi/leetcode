class MinStack {

    private final Stack<Integer> values = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    
    public void push(int val) {
       values.push(val);

       if (min.isEmpty() || val <= min.peek()) {
           min.push(val);
       }
    }
    
    public void pop() {
        if (min.peek().equals(values.pop())) {
            min.pop();
        }
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */