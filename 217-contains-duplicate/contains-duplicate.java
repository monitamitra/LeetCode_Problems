class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (freq.contains(val)) {
                    return true;
            } 
                freq.add(val);
        }
        return false;
    }
}