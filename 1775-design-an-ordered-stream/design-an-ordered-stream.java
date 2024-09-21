class OrderedStream {
    private HashMap<Integer, String> stream;
    private int curr;

    public OrderedStream(int n) {
        stream =  new HashMap<>();
        curr = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        
        if (idKey == curr) {
            res.add(value);
            while (stream.containsKey(++curr)) {
                res.add(stream.remove(curr));
            }
        } else {
            stream.put(idKey, value);
        }
        
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */