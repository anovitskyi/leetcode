class MyQueue {

    private final Stack<Integer> in = new Stack<>();
    private final Stack<Integer> out = new Stack<>();
    
    public void push(int x) {
        in.push(x);    
    }
    
    public int pop() {
        copy();
        return out.pop();
    }
    
    public int peek() {
        copy();    
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();    
    }
    
    private void copy() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }   
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