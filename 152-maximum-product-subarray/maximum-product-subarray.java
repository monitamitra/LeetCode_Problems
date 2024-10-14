class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (left == 0) {
                left = 1;
            }

            if (right == 0) {
                right = 1;
            }

            left *= nums[i];
            right *= nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
}