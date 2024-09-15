class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int curr_val = nums[mid];

            if (curr_val == target) {
                return mid;
            } else if (target > curr_val) {
                low = mid + 1;
            } else if (target < curr_val) {
                high = mid - 1;
            }

        }
        return low;
    }
}