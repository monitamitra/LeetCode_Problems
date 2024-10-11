class Solution {
    public int missingNumber(int[] nums) {
        int[] res = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            res[curr]++;
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (res[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}