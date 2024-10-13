class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        // frequencies of each elem in nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // add corresponding key to its bucket to its frequency
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // loop through bucket and add k most frequent elements
        int[] res = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    res[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return res;
    }
}