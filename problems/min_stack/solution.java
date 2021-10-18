class MinStack {

    private final Stack<Integer> curr = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    
    public void push(int val) {
        curr.push(val);
        if (min.isEmpty() || getMin() >= val) {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = curr.pop();
        if (getMin() == val) {
            min.pop();
        }
    }
    
    public int top() {
        return curr.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}