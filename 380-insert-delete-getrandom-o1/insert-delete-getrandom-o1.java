class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // swapping
        int index = map.get(val);
        int old_elem = list.get(list.size() - 1);
        
        list.set(index, old_elem);
        map.put(old_elem, index);
        list.remove(list.size() - 1);

        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * (list.size()));
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */