class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

       int res = 0;
       int curr = 0;
       for (int num : nums) {
        if (!set.contains(num - 1)) {
            int temp = num;
            curr = 1;
            while (set.contains(temp + 1)) {
                curr++;
                temp++;
            }
          }
          res = Math.max(curr, res);
       }
       return res;
    }
}