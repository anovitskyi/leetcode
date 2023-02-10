class LRUCache {

    private final int capacity;
    private final Map<Integer, ListNode> map;
    private final ListNode head;

    private int size;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode();
        this.tail = this.head;
    }

    private boolean containsKey(int key) {
        return map.containsKey(key) && map.get(key) != null;
    }
    
    public int get(int key) {
        if (!containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (containsKey(key)) {
            ListNode tmp = map.get(key);
            tmp.prev.next = tmp.next;
            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            }
            if (tail == tmp) {
                tail = tail.prev;
            }
            --size;
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
        ++size;

        if (size > capacity) {
            ListNode tmp = head.next;
            map.put(tmp.key, null);
            tmp.prev.next = tmp.next;
            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            }
            if (tail == tmp) {
                tail = tmp.prev;
            }
            --size;
        }
    }

    private static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode() {
            this(0, 0);
        }

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}