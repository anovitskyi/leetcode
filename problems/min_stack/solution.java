class MinStack {
    
    private final Stack<Integer> curr = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    
    public void push(int val) {
        curr.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }
    
    public void pop() {
        if (top() == getMin()) {
            min.pop();
        }
        
        curr.pop();
    }
    
    public int top() {
        return curr.peek();
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