class MyStack {

    private final Queue<Integer> queue = new LinkedList<>();
    
    public void push(int x) {
        queue.offer(x);
        
        int size = queue.size() - 1;
        while (size-- > 0) {
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

/*
    [1, 2, 3, 4, 5]
    
    [1, 2, 3, 4, 5]
    
    1. []
    2. [1]
    3. [1, 2] -> [2, 1]
    4. [2, 1, 3] -> [1, 3, 2] -> [3, 2, 1]
    5. [3, 2, 1, 4] -> [2, 1, 4, 3] -> [1, 4, 3, 2] -> [4, 3, 2, 1]
*/

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */