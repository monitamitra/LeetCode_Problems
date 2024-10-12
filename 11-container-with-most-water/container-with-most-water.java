class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int res = 0;
        int high = height.length - 1;

        while (low < high) {
            int curr = (high - low) * Math.min(height[low], height[high]);
            res = Math.max(res, curr);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return res;
    }
}