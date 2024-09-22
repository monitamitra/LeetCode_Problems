class Solution {
    public int trap(int[] height) {
        int left_max = 0;
        int right_max = 0;
        int res = 0;

        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            left_max = Math.max(left_max, height[i]);
            right_max = Math.max(right_max, height[j]);
            if (left_max < right_max) {
                res += (left_max - height[i]);
                i++;
                left_max = Math.max(left_max, height[i]);
            } else {
                res += (right_max - height[j]);
                j--;
                right_max = Math.max(right_max, height[j]);
            }
        }
        return res;
    }
}