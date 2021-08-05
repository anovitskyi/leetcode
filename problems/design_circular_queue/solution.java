class MyCircularQueue {
    
    private int head;
    private int tail;
    private int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k + 1];
        head = 0;
        tail = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        arr[tail++] = value;
        if (tail >= arr.length) {
            tail = 0;
        }
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        ++head;
        if (head >= arr.length) {
            head = 0;
        }
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        
        return arr[head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        int prev = tail - 1;
        if (prev < 0) {
            prev = arr.length - 1;
        }
        
        return arr[prev];
    }
    
    public boolean isEmpty() {
        return head == tail;
    }
    
    public boolean isFull() {
        int next = tail + 1;
        if (next >= arr.length) {
            next = 0;
        }
        
        return next == head;
    }
}