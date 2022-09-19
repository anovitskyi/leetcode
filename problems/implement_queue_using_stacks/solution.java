class MyQueue {
    
    private final Stack<Integer> queue = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        int peek = peek();
        queue.pop();
        return peek;
    }
    
    public int peek() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */