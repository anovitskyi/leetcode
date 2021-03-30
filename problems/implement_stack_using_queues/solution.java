class MyStack {

    private final Queue<Integer> queue = new LinkedList<>();
    
    public void push(int x) {
        queue.offer(x);
        
        int size = queue.size();
        while (--size > 0) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}