class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int res = 1;
        for (int right = 0; right < nums.length; right++) {
            res *= nums[right];
            while (res >= k && left <= right) {
                res /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}