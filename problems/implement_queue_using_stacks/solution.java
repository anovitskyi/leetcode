class MyQueue {

    private final Stack<Integer> read = new Stack<>();
    private final Stack<Integer> write = new Stack<>();
    
    public void push(int x) {
        write.push(x);
    }
    
    public int pop() {
        transferWriteToRead();
        return read.pop();
    }
    
    public int peek() {
        transferWriteToRead();
        return read.peek();
    }
    
    public boolean empty() {
        return read.isEmpty() && write.isEmpty();
    }
    
    private void transferWriteToRead() {
        if (!read.isEmpty()) {
            return;    
        }
        
        while (!write.isEmpty()) {
            read.push(write.pop());
        }
    }
}