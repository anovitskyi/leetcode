class MyCircularQueue {
    
    private int front;
    private int end;
    private final int[] queue;

    public MyCircularQueue(int k) {
        front = 0;
        end = 0;
        queue = new int[k + 1];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        queue[end] = value;
        ++end;
        if (end >= queue.length) {
            end = 0;
        }
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        ++front;
        if (front >= queue.length) {
            front = 0;
        }
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        int prev = end - 1;
        if (prev < 0) {
            prev = queue.length - 1;
        }
        
        return queue[prev];
    }
    
    public boolean isEmpty() {
        return front == end;
    }
    
    public boolean isFull() {
        int next = end + 1;
        
        if (next >= queue.length) {
            next = 0;
        }
        
        return next == front;
    }
}