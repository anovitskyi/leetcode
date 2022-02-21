class MyCircularQueue {
    
    private final int[] elements;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        elements = new int[k + 1];
        head = 0;
        tail = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        elements[tail] = value;
        tail = getNextIndex(tail);
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        head = getNextIndex(head);
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        
        return elements[head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        return elements[getPrevIndex(tail)];
    }
    
    public boolean isEmpty() {
        return head == tail;
    }
    
    public boolean isFull() {
        return head == getNextIndex(tail);
    }
    
    private int getNextIndex(int index) {
        return (index + 1) % elements.length;
    }
    
    private int getPrevIndex(int index) {
        return (((index - 1) % elements.length) + elements.length) % elements.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */