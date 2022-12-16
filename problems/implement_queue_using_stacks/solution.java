class MyQueue {

    private final Stack<Integer> read = new Stack<>();
    private final Stack<Integer> write = new Stack<>();
    
    public void push(int x) {
        write.push(x);
    }
    
    public int pop() {
        int peek = peek();
        read.pop();
        return peek;
    }
    
    public int peek() {
        if (read.isEmpty()) {
            while (!write.isEmpty()) {
                read.push(write.pop());
            }
        }

        return read.peek();    
    }
    
    public boolean empty() {
        return read.isEmpty() && write.isEmpty();
    }
}