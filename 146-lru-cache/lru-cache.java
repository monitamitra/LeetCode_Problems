class LRUCache {

    class DLLNode {
        DLLNode prev, next;
        int key, val;

        DLLNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    private DLLNode head; 
    private DLLNode tail;

    private HashMap<Integer, DLLNode> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new DLLNode(-1,-1);
        this.tail = new DLLNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLLNode node = cache.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
            cache.put(key, node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            DLLNode newNode = new DLLNode(key, value);
            insertAfterHead(newNode);
            cache.put(key, newNode);
        }

    }

     public void deleteNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }

    //just putting the newNode after the head
    public void insertAfterHead(DLLNode node) { 
        DLLNode afterNode = head.next;
        head.next = node;
        node.prev = head;
        afterNode.prev = node;
        node.next = afterNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */