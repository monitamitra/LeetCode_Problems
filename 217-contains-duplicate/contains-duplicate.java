class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (freq.containsKey(val) && freq.get(val) >= 1) {
                    return true;
            } 
                freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        return false;
    }
}