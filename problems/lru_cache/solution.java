class LRUCache {

    int capacity;
    int size;
    // head and tail of the double linked list
    Node head;
    Node tail;
    // hashmap, from key to Node
    Map<Integer, Node> keyToNode;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // initialize head and tail to be dummy non-null nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.keyToNode = new HashMap<>();
    }
    
    public int get(int key) {
        if (this.keyToNode.containsKey(key)) {
            Node node = this.keyToNode.get(key);
            deleteNode(node);
            insertAtHead(node);
            
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.keyToNode.containsKey(key)) {
            Node node = this.keyToNode.get(key);
            deleteNode(node);
        }
        else if (this.size == this.capacity) {
            Node node = this.tail.prev;
            deleteNode(node);
            // do not forget to remove the entry from the hashmap
            this.keyToNode.remove(node.key); 
        }
        Node node = new Node(key, value);
        insertAtHead(node);
        this.keyToNode.put(key, node);
    }
    
    // function method to delete a node from the doubly linkedlist
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size--;
    }
    
    
    // insert a node at the head of the linkedlist
    private void insertAtHead(Node node) {
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
        node.prev = this.head;
        this.size++;
    }
    
    // inner class, node for a doubly-linkedlist
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */