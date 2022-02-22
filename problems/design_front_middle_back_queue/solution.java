class FrontMiddleBackQueue {
    
    private QueueNode head;
    private QueueNode tail;
    private int size;
    
    public FrontMiddleBackQueue() {
        head = tail = new QueueNode();
        size = 0;
    }
    
    public void pushFront(int val) {
        QueueNode newNode = new QueueNode(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        ++size;
    }
    
    public void pushMiddle(int val) {
        int middle = size / 2;
        if (middle == 0) {
            pushFront(val);
            return;
        } 
        
        QueueNode tmp = head;
        while (middle-- > 0) {
            tmp = tmp.next;
        }
        
        QueueNode newNode = new QueueNode(val);
        newNode.next = tmp;
        newNode.prev = tmp.prev;
        newNode.prev.next = newNode;
        tmp.prev = newNode;
        ++size;
    }
    
    public void pushBack(int val) {
        QueueNode emptyNode = new QueueNode();
        tail.val = val;
        tail.next = emptyNode;
        emptyNode.prev = tail;
        tail = emptyNode;
        ++size;
    }
    
    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        
        int val = head.val;
        head = head.next;
        head.prev = null;
        --size;
        return val;
    }
    
    public int popMiddle() {
        int middle = (size - 1) / 2;
        if (middle == 0) {
            return popFront();
        }
        
        QueueNode tmp = head;
        while (middle-- > 0) {
            tmp = tmp.next;
        }
        
        int val = tmp.val;
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        --size;
        return val;
    }
    
    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        
        int val = tail.prev.val;
        tail = tail.prev;
        tail.next = null;
        --size;
        return val;
    }
    
    private boolean isEmpty() {
        return size == 0;
    }
    
    private class QueueNode {
        int val;
        QueueNode prev;        
        QueueNode next;
        
        QueueNode() {
        }
        
        QueueNode(int val) {
            this.val = val;
        }
        
        QueueNode(int val, QueueNode prev, QueueNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */