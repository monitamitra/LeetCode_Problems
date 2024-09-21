class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> allStrings = new HashSet<>();
        int res = 0;
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (!allStrings.contains(curr)) {
                allStrings.add(curr);
                i++;
                res = Math.max(res, allStrings.size());
            } else {
                allStrings.remove(s.charAt(j));
                j++;
            }
        }
        return res;
    }
}