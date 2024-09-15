class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                return new int[]{i, seen.get(nums[i])};
            } else {
                seen.put(target - nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}