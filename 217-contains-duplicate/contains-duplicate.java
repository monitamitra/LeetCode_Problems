class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.get(nums[i]) == null) {
                freq.put(nums[i], 1);
            } else if (freq.get(nums[i]) >= 1) {
                return true;
            }
        }
        return false;
    }
}