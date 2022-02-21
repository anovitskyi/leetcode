class MyCircularDeque {
    
    private final int[] elements;
    private int headIndex;
    private int tailIndex;

    public MyCircularDeque(int k) {
        elements = new int[k + 1];
        headIndex = 0;
        tailIndex = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        
        headIndex = getPrevIndex(headIndex);
        elements[headIndex] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        
        elements[tailIndex] = value;
        tailIndex = getNextIndex(tailIndex);
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        
        headIndex = getNextIndex(headIndex);
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        
        tailIndex = getPrevIndex(tailIndex);
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        
        return elements[headIndex];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        
        return elements[getPrevIndex(tailIndex)];
    }
    
    public boolean isEmpty() {
        return headIndex == tailIndex;
    }
    
    public boolean isFull() {
        return headIndex == getNextIndex(tailIndex);
    }
    
    private int getNextIndex(int index) {
        return (index + 1) % elements.length;
    }
    
    private int getPrevIndex(int index) {
        return (((index - 1) % elements.length) + elements.length) % elements.length;
    }
    
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */