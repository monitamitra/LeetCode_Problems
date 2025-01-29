class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int j = 0;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res *= nums[i];
            while (res >= k && j <= i) {
                res /= nums[j];
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }
}